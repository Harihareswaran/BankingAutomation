pipeline {
    agent any

    tools {
        maven 'Maven-3.9.6'
        jdk 'JDK-11'
    }

    environment {
        ANDROID_HOME = "C:\\path\\to\\android\\sdk"
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out code..."
                git url: 'https://github.com/Harihareswaran/BankingAutomation.git', branch: 'main'
            }
        }

        stage('Build Project') {
            steps {
                echo "Building project..."
                bat 'mvn clean compile'
            }
        }

        stage('Run Smoke Tests') {
            steps {
                echo "Running SMOKE tests..."
                bat 'mvn test -Dcucumber.filter.tags="@smoke"'
            }
        }

        stage('Run Regression Tests') {
            steps {
                echo "Running REGRESSION tests..."
                bat 'mvn test -Dcucumber.filter.tags="@regression"'
            }
        }

        stage('Generate Reports') {
            steps {
                echo 'Publishing Cucumber and TestNG reports...'
                cucumber(
                    buildStatus: 'UNSTABLE', 
                    fileIncludePattern: 'target/cucumber-report.json', 
                    jsonReportDirectory: 'target', 
                    pluginFormat: 'json'
                )
            }
        }
    }

    post {
        always {
            echo "Archiving artifacts and JUnit reports..."
            archiveArtifacts artifacts: '**/target/*.html', allowEmptyArchive: true
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            echo "Build & tests completed successfully"
        }
        unstable {
            echo "Build unstable"
        }
        failure {
            echo "Build failed "
        }
    }
}
