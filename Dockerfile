FROM openjdk:8u292-oracle-dynatrace

USER root

WORKDIR /opt/

COPY target/entity-service-cliente-v1-0.0.1-SNAPSHOT.jar file.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/opt/file.jar"]