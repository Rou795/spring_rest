FROM openjdk:17-jdk-alpine

EXPOSE 8081

COPY target/avtorizationService-0.0.1-SNAPSHOT.jar myapp.jar

CMD ["java", "-jar", "/myapp.jar"]