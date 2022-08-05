FROM openjdk:11-slim as build

MAINTAINER robot23ref

COPY target/loans-0.0.1-SNAPSHOT.jar loans-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/loans-0.0.1-SNAPSHOT.jar"]