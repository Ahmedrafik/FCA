FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /build/libs/rs-api-0.0.1-SNAPSHOT.jar rs-api.jar
ENTRYPOINT ["java", "-jar", "rs-api.jar"]