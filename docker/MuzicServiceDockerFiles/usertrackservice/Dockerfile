FROM openjdk:8-jre
RUN mkdir usr/usertrackservice
WORKDIR usr/usertrackservice
ENV USER_TRACK_SERVICE_PORT=9010
ENV MONGO_DATABASENAME=muzixdb
ENV MONGO_URL=mongodb://localhost:27017/muzixdb
COPY ./target/usertrackservice-0.0.1-SNAPSHOT.jar usertrackservice.jar
ENTRYPOINT ["java", "-jar", "usertrackservice.jar"]
