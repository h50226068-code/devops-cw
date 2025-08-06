pipeline {
    agent any

    environment {
        SONAR_TOKEN = credentials('sonar-token')  // Reference the token stored in Jenkins credentials
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the specific branch from your GitHub repository
                git url: 'https://github.com/h50226068-code/devops-cw.git', branch: 'my-branch'
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                script {
                    // Run the SonarQube analysis with the stored token
                    withSonarQubeEnv('SonarQube') {  // SonarQube configuration in Jenkins
                        sh "sonar-scanner -Dsonar.login=${SONAR_TOKEN}"  // Running the analysis
                    }
                }
            }
        }
    }
}
pipeline {
    agent any

    environment {
        SONAR_TOKEN = credentials('sonar-token')  // Reference the token stored in Jenkins credentials
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the specific branch from your GitHub repository
                git url: 'https://github.com/h50226068-code/devops-cw.git', branch: 'my-branch'
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                script {
                    // Run the SonarQube analysis with the stored token
                    withSonarQubeEnv('SonarQube') {  // SonarQube configuration in Jenkins
                        sh "sonar-scanner -Dsonar.login=${SONAR_TOKEN}"  // Running the analysis
                    }
                }
            }
        }
    }
}
