node {
  satge ('SCM checkout') {
    git branch: 'main', url: 'https://github.com/asifkhazi/new-java-project.git'
  }
  stage ('Test') {
    sh 'echo "Test"'
  }
  stage ('Build') {
    sh 'mvn clean install'
  }
  stage ('Deploy') {
    sh 'rsync -arzvh ${WORKSPACE}/target/*.jar /opt/tomcat/webapps/'
  }
}
