node {
    properties(
        properties(
            [parameters([choice(choices: 
            ['golden_ami', 'elk', 'tower', 'nagiosxi', 'gitlab', 'nexus', 'vault'], 
            description: 'what tool would you like to build', name: 'TOOL_TO_PROVISION'), 
            choice(choices: ['us-east-1', 'us-east-2', 'us-west-1', 'us-west-2'], 
            description: 'choose the region', name: 'AMI_REGION')])])

    stage("Pull repo"){
        git 'https://github.com/farrukh90/packer.git'
    }
    stage("Build image"){
        sh "packer version"
        sh "packer build -var region=${AMI_REGION} tools/jenkins_example.json"
    }
    stage("Send notification to Slack"){
        slackSend channel: 'jenkins', message: 'GoldenAmi has been built in ${AMI_REGION}'
    }
    stage("Send email"){
        mail bcc: '', body: 'Your ubuntu golden AMI is ready in ${AMI_REGION}', cc: '', from: '', replyTo: '', subject: 'GoldenAMI is ready', to: 'talantasan@outlook.com'
    }
}
