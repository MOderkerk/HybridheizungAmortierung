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
    stage('Build')
    {
       withMaven(jdk: 'java', maven: 'maven') {
        sh 'mvn test'  
       }    
    }
    
    stage('Pack & Deploy')
    {
       archive 'target/*.jar'
           
    }
    
}