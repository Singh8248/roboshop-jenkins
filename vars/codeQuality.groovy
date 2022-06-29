def call() {
  sh '''
    sonar-scanner -Dsonar.host.url=http://172.31.92.121:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=${env.COMPONENT}
  '''
}
