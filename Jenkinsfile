pipeline {
    environment {
        registry = "902316339693.dkr.ecr.us-east-2.amazonaws.com/jw-flights"
        dockerImage = ''
    }
    agent any
    tools { 
        maven 'mvn' 
        jdk 'java' 
    }
    stages {
        stage('Docker build') {
            steps {
                echo 'Maven packaging:'
                sh 'mvn package'
                echo 'Building image:'
                script{
                    flightimage = docker.build registry + ":flightimage"
                }  
            }
        }
        stage('Sonarqube check'){
            steps{
                sh"mvn verify sonar:sonar -Dsonar.projectKey=flights-microservice -Dsonar.host.url=http://jenkins.hitec.link:9000 -Dsonar.login=${params.sonarqubekey}"
            }
        }
        stage('Push Image'){
            steps{
                echo 'Pushing image to ECR:'
                sh 'docker context use default'
                script{
                    docker.withRegistry('https://902316339693.dkr.ecr.us-east-2.amazonaws.com', 'ecr:us-east-2:jw-aws-cred'){
                        flightimage.push()
                    }
                }
            }
        }
        stage('Call docker-compose'){
            steps{
                echo 'Calling docker-compose job'
                build job: 'JW-Docker-Compose'
            }
        }
    }
}