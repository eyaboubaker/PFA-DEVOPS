pipeline {
    agent any
tools {
    maven "maven"
    }
stages {
    stage("Code Checkout from github") {
        steps {
            git branch: 'master' ,url:'https://github.com/eyaboubaker/PFA-DEVOPS.git'
            
  }
}
stage("Compile"){
            steps{
                sh "mvn clean compile"
            }
        }
stage('SCA with OWASP Dependency Check') {
        steps {
            dependencyCheck additionalArguments: '--scan ./ --disableYarnAudit --disableNodeAudit', odcInstallation: 'DP-Check'
            dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
    }
stage('TRIVY FS SCAN') {
            steps {
                sh "trivy fs . > trivyfs.txt"
            }
        }
        
stage("Maven Build") {
            steps {
                script {
                    sh "mvn -Dmaven.test.failure.ignore=true clean package"
                }
            }
        }
stage('SAST with SonarQube'){
        steps{
            withSonarQubeEnv('sonarqube'){
                sh " mvn sonar:sonar -Dsonar.host.url=http://192.168.0.16:9000/  -Dsonar.projectName=PFA-DEVOPS" 

 
            }
        }
    }
 
 stage('docker build image'){
        steps{
            sh 'docker build -t boubakereya22/new:tag123 .'
        }
    }
 stage('docker push image'){
        steps{
            script{
            withDockerRegistry(credentialsId: 'docker'){
                sh 'docker push boubakereya22/new:tag123 '}
            }
        }
    }
 stage('Trivy scan on Docker image'){
        steps{
             sh 'trivy image boubakereya22/new:tag123'
        }
       
    } 
stage('Deploying Docker Image'){
        steps{
            script{
            withDockerRegistry(credentialsId: 'docker'){
                sh 'docker run -d --name new4 -p 8081:8080 boubakereya22/new:tag123'}
            }
        }
    }

  }
}
