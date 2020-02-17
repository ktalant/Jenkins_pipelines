pipeline {
  agent any

  parameters {
                string(name: 'AWS_REGION', description: 'Enter the region')
            }
  stages {

    stage ('Configure AWS Credentials') {
      steps {
        echo 'Set up aws credentials to ${AWS_REGION}'
        sh '''
        ls -a
        '''
      }
    }
  }
}
