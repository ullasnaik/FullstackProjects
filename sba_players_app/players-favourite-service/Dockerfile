FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_URI mongodb://localhost:27017/PlayerFavDB
ADD ./target/players-favourite-service-0.0.1-SNAPSHOT.jar /usr/src/players-favourite-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","players-favourite-service-0.0.1-SNAPSHOT.jar"]
