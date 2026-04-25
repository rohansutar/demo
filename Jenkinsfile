pipeline {
    agent any
    tools {
        maven 'Maven_3_9'
        jdk 'JDK17'
    }
    environment {
        DB_URL = 'jdbc:h2:mem:testdb'
        DB_USER = 'sa'
        DB_PASSWORD = credentials('db-password')
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/rohansutar/demo.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn test -Dspring.profiles.active=local'
            }
        }
    }
}
