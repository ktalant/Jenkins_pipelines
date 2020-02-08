node {
    stage("Pull repo"){
        echo "Hello"
    }
    stage("Build image"){
        sh "packer version"
    }
    stage("Send notification to Slack"){
        echo "Hello"
    }
    stage("Send email"){
        echo "Hello"
    }
}
