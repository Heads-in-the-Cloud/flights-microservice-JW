pipeline {
    agent any
    environment {
        registry = "902316339693.dkr.ecr.us-east-2.amazonaws.com/jw-flights"
        dockerImage = ''
    }
    parameters{
        string(name:'sonarqubekey', defaultValue: 'NULL', description: 'sonarqube key')
        string(name: 'registry', defaultValue: 'NULL', description: 'registry url')
    }
    tools { 
        maven 'mvn' 
        jdk 'java' 
    }
    stages {
        stage('Sonarqube check'){
            steps{
                withSonarQubeEnv('sonarqube'){
                    sh"mvn verify sonar:sonar -Dsonar.projectKey=bookings-microservice -Dsonar.host.url=http://jenkins.hitec.link:9000 -Dsonar.login=${params.sonarqubekey}"
                }
            }
        }
        stage('Quality gate'){
            steps{
                waitForQualityGate abortPipeline: true
            }
        }
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