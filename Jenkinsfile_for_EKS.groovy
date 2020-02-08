node {
    stage("Pull repo"){
        git 'https://github.com/ktalant/terraform-iaac-eks-burak.git'
    }
    stage("Provision EKS with terraform"){
        echo "terraform version"
    }
    stage("Stage3"){
        echo "Hello"
    }
    stage("Stage4"){
        echo "Hello"
    }
}