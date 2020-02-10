node {
    properties(
        //dicard old builds parameter
        [buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', 
        numToKeepStr: '4')),
        
        
        [parameters([
            //choice parameter for app_version
            choice(choices: ['version/0.1', 'version/0.2', 'version/0.3', 'version/0.4', 'version/0.5'], 
            description: 'choose ARTEMIS_APP_VERSION to be deployed', name: 'ARTEMIS_VERSION'),

            //choice parameter for app_envrionment
            choice(choices: ['dev1.talantzon.com', 'qa1.talantzon.com', 'stage1.talantzon.com', 'prod1.talantzon.com'], 
            description: 'Choose Environment ', name: 'ARTEMIS_ENV')
            
            ])])


    stage("Pull repo"){

    }
    stage("Pull repo"){
        
    }
    stage("Pull repo"){
        
    }
    stage("Pull repo"){
        
    }
}