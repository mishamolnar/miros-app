FROM openjdk:11-slim as build

MAINTAINER robot23ref

COPY target/cards-0.0.1-SNAPSHOT.jar cards-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/cards-0.0.1-SNAPSHOT.jar"]