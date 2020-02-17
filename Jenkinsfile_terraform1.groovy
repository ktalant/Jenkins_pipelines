pipeline {
  agent any
  stages {
    stage ('Configure AWS Credentials') {
      parameters {
                    string(name: 'AWS_REGION', description: 'Enter the region')
                }
            }
      steps {
        echo "Set up aws credentials to ${AWS_REGION}"
        sh '''
        ls -a
        '''
      }
    }
  }
