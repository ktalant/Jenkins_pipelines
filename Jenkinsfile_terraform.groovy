pipeline {

  agent any
  stages {
    stage ('Configure AWS Credentials') {
      steps {
        echo 'Set up aws credentials'
        sh '''
          aws configure set aws_access_key_id ${AWS_ACCESS_KEY_ID} --profile ${AWS_PROFILE}
          aws configure set aws_secret_access_key ${AWS_SECRET_ACCESS_KEY} --profile ${AWS_PROFILE}
          aws configure set region ${AWS_REGION} --profile ${AWS_PROFILE}
        '''
      }
    }
  }
}
