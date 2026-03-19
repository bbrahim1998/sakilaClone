# Imatge base oficial de Tomcat
FROM tomcat:10.1-jdk17

RUN rm -rf /usr/local/tomcat/webapps/*

# Configuració Tomcat
COPY config/* /usr/local/tomcat/conf/
COPY lib/* /usr/local/tomcat/lib/

# Aplicació
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war
