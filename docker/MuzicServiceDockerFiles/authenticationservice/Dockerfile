FROM openjdk:8-jre
WORKDIR usr/authservice
ENV AUTHENTICATION_SERVICE_PORT=9005
ENV MYSQL_DATABASE=UserDb
ENV MYSQL_URL=jdbc:mysql://localhost:3306/UserDb
ENV MYSQL_USER=approot
ENV MYSQL_PASSWORD=pass
COPY ./target/authenticationservice-0.0.1-SNAPSHOT.jar authenticationservice.jar
ENTRYPOINT ["java", "-jar", "authenticationservice.jar"]