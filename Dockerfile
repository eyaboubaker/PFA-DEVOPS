FROM tomcat:1.0.0-M11-jdk21-openjdk-bookworm
COPY target/clinique-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/
