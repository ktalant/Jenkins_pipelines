pipeline {
  agent any
  stages {
    stage ('Configure AWS Credentials') {
      steps {
        echo 'Set up aws credentials'
        sh '''
        ls -a
        '''
      }
    }
  }
}
