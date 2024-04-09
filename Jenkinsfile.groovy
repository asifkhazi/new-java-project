node {
  satge ('SCM checkout') {
    git branch: 'master', url: 'https://github.com/asifkhazi/Jenkins-Decalarative-sample-java-war-hello.git'
  }
  stage ('Test') {
    sh 'echo "Test"'
  }
  stage ('Build') {
    sh 'mvn clean install'
  }
  stage ('Deploy') {
    sh 'rsync -arzvh ${WORKSPACE}/target/*.war /opt/tomcat/webapps/'
  }
}
