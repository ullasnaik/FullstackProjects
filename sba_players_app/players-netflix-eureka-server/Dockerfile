FROM openjdk:11-jre-slim
WORKDIR usr/src
ADD ./target/players-netflix-eureka-server-0.0.1-SNAPSHOT.jar /usr/src/players-netflix-eureka-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","players-netflix-eureka-server-0.0.1-SNAPSHOT.jar"]
