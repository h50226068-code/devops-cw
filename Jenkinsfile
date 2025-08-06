pipeline {
    agent any

    environment {
        SONAR_TOKEN = credentials('sonar-token')  // Reference the token stored in Jenkins credentials
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm  // Checkout your source code from Git
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    // Run the SonarQube analysis
                    withSonarQubeEnv('SonarQube') {  // Use the SonarQube configuration name from Jenkins
                        sh "/opt/sonar-scanner-4.6.2.2472-linux/bin/sonar-scanner -Dsonar.login=${SONAR_TOKEN}"  // Running the analysis with token
                    }
                }
            }
        }
    }
}

