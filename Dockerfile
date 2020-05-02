FROM openjdk:8-jre
COPY target/SimplePostBackend-0.0.1.RELEASE.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]