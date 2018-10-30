properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '10', numToKeepStr: '10')), disableConcurrentBuilds(), [$class: 'GithubProjectProperty', displayName: '', projectUrlStr: 'https://github.com/MOderkerk/HybridheizungAmortierung/'], pipelineTriggers([cron('@weekly'), githubPush()])])

node('master')
{
    stage('checkout') {
     checkout scm ,extensions: [[$class: 'CleanBeforeCheckout']]
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
      zip archive: true, dir: 'target/', glob: 'H*.jar', zipFile: 'Amortisierungsrechner.zip'
           
    }
    
}