pipeline {
    agent any

    environment {
        SONAR_TOKEN = credentials('sonar-token')  // Reference the token stored in Jenkins credentials
        PATH = "/opt/sonar-scanner-4.6.2.2472-linux/bin:${env.PATH}"  // Add sonar-scanner to PATH
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
                    // Run the SonarQube analysis securely
                    withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
                        withSonarQubeEnv('SonarQube') {  // Use the SonarQube configuration name from Jenkins
                            sh """
                                /opt/sonar-scanner-4.6.2.2472-linux/bin/sonar-scanner \
                                -Dsonar.login=${SONAR_TOKEN} \
                                -Dsonar.projectKey=my_project_key \
                                -Dsonar.projectName=My Project \
                                -Dsonar.projectVersion=1.0
                            """
                        }
                    }
                }
            }
        }
    }
}
