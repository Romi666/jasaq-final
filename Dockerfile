FROM openjdk:11-jre
COPY target/JasaQ-0.0.1.RELEASE.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]