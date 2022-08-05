FROM openjdk:11-slim as build

MAINTAINER robot23ref

COPY target/gatewayserver-0.0.1-SNAPSHOT.jar gatewayserver-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/gatewayserver-0.0.1-SNAPSHOT.jar"]