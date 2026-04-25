pipeline {
    agent any

    environment {
        DB_URL = 'jdbc:h2:mem:testdb'
        DB_USER = 'sa'
        DB_PASSWORD = ''
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/rohansutar/demo.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Run Tests') {
            steps {
                bat 'mvn test -Dspring.profiles.active=local'
            }
        }
    }
}
