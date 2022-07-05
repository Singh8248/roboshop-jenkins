def call() {
  pipeline {
    agent any

    options {
      ansiColor('xterm')
    }

    parameters {
      string(name: 'ENV', defaultValue: '', description: 'Which Environment?')
      string(name: 'VERSION', defaultValue: '', description: 'Which Version?')
    }

    environment {
      SSH = credentials('SSH')
    }

    stages {

      stage('Terraform INIT') {
        steps {
          sh '''
            terraform init -backend-config=env-${ENV}/backend.tfvars
          '''
        }
      }

      stage('Terraform Apply') {
        steps {
          sh '''
            terraform apply -auto-approve -var-file=env-${ENV}/${ENV}.tfvars -var APP_VERSION=${VERSION} -parallelism=1
          '''
        }
      }

    }

    post {
      always {
        cleanWs()
      }
    }

  }
}