def call() {
  node{
    sh 'rm -rf "*"'
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
