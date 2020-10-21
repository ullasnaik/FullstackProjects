FROM openjdk:11-jre-slim
WORKDIR usr/src
ADD ./target/EurekaService-0.0.1-SNAPSHOT.jar /usr/src/EurekaService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","EurekaService-0.0.1-SNAPSHOT.jar"]