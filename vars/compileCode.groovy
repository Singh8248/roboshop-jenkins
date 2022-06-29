def compile() {
  if (env.APPTYPE == "nodejs" ) {
    sh 'echo "NodeJS does not require Compilation'
  }
}

