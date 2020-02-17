pipeline {
  properties([
    buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '4')),
    parameters([
      string(defaultValue: '', description: 'Enter aws profile', name: 'AWS_PROFILE', trim: false),
      string(defaultValue: '', description: 'Paste AWS access key id', name: 'AWS_ACCESS_KEY_ID', trim: false),
      string(defaultValue: '', description: 'Paste AWS secret access key', name: 'AWS_SECRET_ACCESS_KEY', trim: false),
      choice(choices: ['us-east-1', 'us-east-2', 'us-west-1', 'us-west-2'], description: 'Choose the region', name: 'AWS_REGION')])])

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
