def call() {
  node{
    sh 'rm -rf "*"'
    print env.TAG_NAME
    if(TAG_NAME ==~ ".*") {
      stage('tag1') {
        sh 'env'
        sh 'echo hello'
      }
      stage('tag2') {
        sh 'echo hello'
      }
    }

    else if(BRANCH_NAME ==~ "PR.*") {
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
