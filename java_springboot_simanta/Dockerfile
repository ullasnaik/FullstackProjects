FROM openjdk:11

ADD ./target/restservicedemo-0.0.1-SNAPSHOT.jar restservicedemo-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "restservicedemo-0.0.1-SNAPSHOT.jar"]
