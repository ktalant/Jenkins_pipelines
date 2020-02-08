node {
    properties([parameters([choice(choices: ['us-east-1', 'us-east-2', 'us-west-1', 'us-west-2'], description: 'Choose the region you want to build the image to.', name: 'AMI_REGION')])])

    stage("Pull repo"){
        git 'https://github.com/farrukh90/packer.git'
    }
    stage("Build image"){
        sh "packer version"
        sh "packer build -var region=${AMI_REGION} tools/jenkins_example.json"
    }
    stage("Send notification to Slack"){
        slackSend channel: '#jenkins'
        echo "Hello ${AMI_REGION}"
    }
    stage("Send email"){
        echo "Hello"
    }
}
