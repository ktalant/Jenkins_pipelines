node {
    properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '3'))])
    stage("Pull repo"){
        git 'https://github.com/ktalant/terraform-iaac-eks-burak.git'
    }
    stage("Provision EKS with terraform"){
        // sh 'wget https://releases.hashicorp.com/terraform/0.12.20/terraform_0.12.20_linux_amd64.zip'
        // sh 'unzip terraform_0.12.20_linux_amd64.zip && ./terraform version'

    }
    stage("Set environment for Terraform"){
        sh 'ls -la'
        //sh "source setenv -var-file=configurations/dev/us-west-2/dev.tfvars"
    }
    stage("Stage4"){
        echo "Hello"
    }
}