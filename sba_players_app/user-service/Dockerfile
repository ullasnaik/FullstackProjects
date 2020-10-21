FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MYSQL_URL jdbc:mysql://localhost:3306/PlayerDB
ENV MYSQL_USERNAME root
ENV MYSQL_PASSWORD root
ADD ./target/user-service-0.0.1-SNAPSHOT.jar /usr/src/user-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","user-service-0.0.1-SNAPSHOT.jar"]
