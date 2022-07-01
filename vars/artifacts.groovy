def prepare() {

  if (env.APPTYPE == "maven" ) {
    sh """
      mvn package 
      mv target/${COMPONENT}-1.0.jar ${COMPONENT}.jar
      zip -r ${COMPONENT}-${TAG_NAME}.zip ${COMPONENT}.jar
    """
  }

  if (env.APPTYPE == "nodejs" ) {
    sh """
      npm install
      zip -r ${COMPONENT}-${TAG_NAME}.zip server.js node_modules
    """
  }

  if (env.APPTYPE == "python" ) {
    sh """
      zip -r ${COMPONENT}-${TAG_NAME}.zip *.py *.ini requirements.txt
    """
  }

}
