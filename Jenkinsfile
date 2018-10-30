properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '10', numToKeepStr: '10')), disableConcurrentBuilds(), [$class: 'GithubProjectProperty', displayName: '', projectUrlStr: 'https://github.com/MOderkerk/HybridheizungAmortierung/'], pipelineTriggers([cron('@weekly'), githubPush()])])

node('master')
{
    stage('checkout') {
     checkout scm 
    }
    
    stage('Build')
    {
       withMaven(jdk: 'java', maven: 'maven') {
        sh 'mvn clean compile -DskipTests=true'  
       }
    
    }
    stage('Build & Package')
    {
       withMaven(jdk: 'java', maven: 'maven') {
        sh 'mvn package'  
       }    
    }
    
    stage('Pack & Deploy')
    {
      try{
          zip archive: true, dir: 'target/', glob: 'H*.jar', zipFile: 'HybridHeizungRechner.zip'
          ftpPublisher alwaysPublishFromMaster: false, continueOnError: false, failOnError: false, publishers: [[configName: '49501-HybridHeizungRechner', transfers: [[asciiMode: false, cleanRemote: false, excludes: '', flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'HybridHeizungRechner.zip']], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: true]]
         }
       catch(Exception err)
       {
    
         echo ('Error')
       } 
     
   
           
    }
    
}