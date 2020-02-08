node {
    stage("Pull repo"){
        git 'https://github.com/ktalant/terraform-iaac-eks-burak.git'
    }
    stage("Stage2"){
        echo "Hello"
    }
    stage("Stage3"){
        echo "Hello"
    }
    stage("Stage4"){
        echo "Hello"
    }
}