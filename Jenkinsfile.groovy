node {
    
    
    stage("Pull repo"){
        git 'https://github.com/farrukh90/packer.git'
    }
    stage("Build image"){
        sh "packer version"
       // sh "packer build -var region=${AMI_REGION} tools/${TOOL_TO_PROVISION}.json"
    }
    stage("Send notification to Slack"){
        slackSend channel: 'jenkins', message: "${TOOL_TO_PROVISION} has been built in ${AMI_REGION}
 "   }
    stage("Send email"){
        mail bcc: '', 
        body: "Your ubuntu golden AMI is ready in ${AMI_REGION}", 
        cc: '', 
        from: '', 
        replyTo: '', 
        subject: "${TOOL_TO_PROVISION} is ready", 
        to: 'talantasan@outlook.com'
    }
}
