def compile() {
  if (env.APPTYPE == "nodejs" ) {
    sh 'echo "NodeJS does not require Compilation"'
  }

  if (env.APPTYPE == "maven" ) {
    sh 'mvn clean compile'
  }

}

