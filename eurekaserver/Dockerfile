FROM openjdk:11-slim as build

MAINTAINER robot23ref

COPY target/eurekaserver-0.0.1-SNAPSHOT.jar eurekaserver-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/eurekaserver-0.0.1-SNAPSHOT.jar"]