pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/h50226068-code/devops-cw.git'
            }
        }

        stage('Build') {
            steps {
                sh 'echo "Building application..."'
            }
        }

        stage('Test') {
            steps {
                sh 'echo "Running tests..."'
            }
        }

        stage('Deploy') {
            steps {
                sh 'echo "Deploying application..."'
            }
        }
    }
}
