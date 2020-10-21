FROM java:8-jre
WORKDIR usr/src
EXPOSE 8080
ADD ./target/demodocker-0.0.1-SNAPSHOT.jar /usr/src/demodocker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "demodocker-0.0.1-SNAPSHOT.jar"]