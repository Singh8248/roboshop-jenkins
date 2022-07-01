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
          unit-tests: {
            echo "unit-tests"
          },
          integration-tests: {
            echo "integration tests"
          },
          smoke-tests: {
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
