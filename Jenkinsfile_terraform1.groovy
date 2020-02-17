pipeline {
  agent any
  options { buildDiscarder(logRotator(numToKeepStr: '4')) }
  parameters {
                choice(name: 'AWS_REGION', choices: ['us-east-1', 'us-east-2', 'us-west-1'], description: '')
                string(name: 'AWS_ACCESS_KEY_ID', description: 'Paste here AWS access key id')
                string(name: 'AWS_SECRET_ACCESS_KEY', description: 'Paste here AWS secret access key id')
                string(name: 'AWS_PROFILE', description: 'Enter you profile')
            }
  stages {

    stage ('Configure AWS Credentials') {
      steps {
        echo "Set up aws credentials to ${AWS_REGION}"
        echo "Here is your ${AWS_ACCESS_KEY_ID}"
        echo "Here is your ${AWS_SECRET_ACCESS_KEY}"
        echo "Here is your --${AWS_PROFILE}"
        sh '''
        ls -a
        '''
      }
    }
  }
}
