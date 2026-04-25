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
                git branch: 'main', url: 'https://github.com/your-username/springboot-app.git'
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