def call() {
  node{
    stage('test') {
      sh 'echo hello'
    }
  }
}
