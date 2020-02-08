node {
    properties([parameters([choice(choices: ['us-east-1', 'us-east-2', 'us-west-1', 'us-west-2'], description: 'Choose the region you want to build the image to.', name: 'AMI_REGION')])])

    stage("Pull repo"){
        echo "Hello"
    }
    stage("Build image"){
        sh "packer version"
    }
    stage("Send notification to Slack"){
        slackSend channel: '#jenkins'
        echo "Hello"
    }
    stage("Send email"){
        echo "Hello"
    }
}
