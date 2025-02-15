pipeline {
    agent any
	tools {
        maven 'Maven_3.8.6'  // Use the Maven name from Jenkins settings
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Rajkumarpatil96/DairyApplication.git'
            }
        }

        stage('Build') {
           steps {
        dir('DairyApplication') { // Adjust this if your project folder is named differently
            bat 'mvn clean package'
			}
		  }
		}

        stage('Test') {
    steps {
        dir('DairyApplication') {
            sh 'mvn test'
        }
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
