FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_URI mongodb://localhost:27017/PlayersRecomDB
ADD ./target/players-recommendation-service-0.0.1-SNAPSHOT.jar /usr/src/players-recommendation-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","players-recommendation-service-0.0.1-SNAPSHOT.jar"]
