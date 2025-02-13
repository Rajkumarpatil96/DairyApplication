pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Rajkumarpatil96/DairyApplication.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying the application..."
                // Add deployment commands here, e.g., copying files or using Docker/Kubernetes
            }
        }
    }
}
