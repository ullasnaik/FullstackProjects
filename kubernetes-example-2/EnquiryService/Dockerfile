FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_URI mongodb://localhost:27017/fitnesszone_db
ENV KAFKA_URL localhost:9092
ADD ./target/EnquiryService-0.0.1-SNAPSHOT.jar /usr/src/EnquiryService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","EnquiryService-0.0.1-SNAPSHOT.jar"]