pipeline {
    agent any
    tools {
        maven "maven"
    }

    stages {
 stage("Code Checkout from github") {
  steps {
   git branch: 'master' ,
    url:'https://github.com/eyaboubaker/PFA-DEVOPS.git'
  }
 }
        stage('OWASP Dependency-Check Vulnerabilities') {
			steps {
				dependencyCheck additionalArguments: ''' 
						-o './'
				    	-s './'
						-f 'ALL' 
						--prettyPrint''', odcInstallation: 'DP-Check'
					
						dependencyCheckPublisher pattern: 'dependency-check-report.html'
						}
					}
        stage("Maven Build") {
            steps {
                script {
                    sh "mvn -Dmaven.test.failure.ignore=true clean package"
                }
            }
        }
           stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                   
               sh "mvn sonar:sonar -Dsonar.host.url=http://192.168.0.16:9000"
               
            }
            }
       
        }
        
    
        
    }
}
