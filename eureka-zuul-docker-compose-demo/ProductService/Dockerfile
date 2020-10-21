FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_URI mongodb://localhost:27017/fitnesszone_db
ADD ./target/ProductService-0.0.1-SNAPSHOT.jar /usr/src/ProductService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ProductService-0.0.1-SNAPSHOT.jar"]