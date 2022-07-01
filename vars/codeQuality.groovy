def call() {
  if (env.APPTYPE == "maven" ) {
  sh """
    #sonar-scanner -Dsonar.host.url=http://172.31.92.121:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=${env.COMPONENT} -Dsonar.java.binaries=target/
    echo OK
  """
  }
  else {
  sh """
    #sonar-scanner -Dsonar.host.url=http://172.31.92.121:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=${env.COMPONENT}
    echo OK
  """
  }

}
