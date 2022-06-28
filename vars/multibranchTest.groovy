def call() {
  node{
    if(BRANCH_NAME == "PR*") {
      stage('PR-STage1') {
        sh 'echo hello'
      }
      stage('PR-STage2') {
        sh 'echo hello'
      }
    }

    else if(BRANCH_NAME != "main") {
      stage('test') {
        sh 'env'
        sh 'echo hello'
      }
      stage('test1') {
        sh 'echo hello'
      }
    }

    else if(BRANCH_NAME == "main") {
      stage('prod') {
        sh 'echo hello'
      }
    }

  }
}
