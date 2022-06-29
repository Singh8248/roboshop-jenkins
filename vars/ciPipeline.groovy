def call() {
  node{
    sh 'rm -rf "*"'
    sh 'git clone https://github.com/raghudevopsb64/${env.COMPONENT} .'
    sh 'ls -ltr'
    compileCode.compile()
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
