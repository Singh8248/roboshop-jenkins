def call() {
  node{
    if(BRANCH_NAME == "main") {
      stage('test') {
        sh 'echo hello'
      }
    }

    if(BRANCH_NAME != "main") {
      stage('prod') {
        sh 'echo hello'
      }
    }

  }
}
