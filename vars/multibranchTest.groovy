def call() {
  pipeline {
    agent any

    options {
      ansiColor('xterm')
    }

    stages {

      stage('CheckOut Code - DEV') {
        when {
          expression {
            BRANCH_NAME == "main"
          }
        }
        steps {
          dir('ANSIBLE') {
            git branch: 'dev', url: 'https://github.com/raghudevopsb64/roboshop-ansible.git'
          }
        }
      }

      stage('CheckOut Code - PROD') {
        when {
          expression {
            BRANCH_NAME != "main"
          }
        }
        steps {
          dir('ANSIBLE') {
            git branch: 'main', url: 'https://github.com/raghudevopsb64/roboshop-ansible.git'
          }
        }
      }

    }

  }
}