def call() {
  node{
    sh 'ls -A | xargs rm -rvf'
    sh "git clone https://github.com/raghudevopsb64/${env.COMPONENT} ."
    sh 'ls -ltr'

    stage('Compile Code') {
      compileCode.compile()
    }

    stage('Code Quality - Sonar') {
      codeQuality()
    }

    stage('Test Cases') {
      parallel([
          unittests: {
            echo "unit-tests"
          },
          integrationtests: {
            echo "integration tests"
          },
          smoketests: {
            echo "smoke tests"
          }
      ])
    }

    if(env.TAG_NAME) {
      print 'OK'
    }

    else if(BRANCH_NAME ==~ "PR.*") {
      print 'OK'
    }

    else if(BRANCH_NAME != "main") {
      print 'OK'
    }

    else if(BRANCH_NAME == "main") {
      print 'OK'
    }

  }
}
