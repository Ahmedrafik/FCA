FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /build/libs/rs-api-0.0.1-SNAPSHOT.jar rs-api.jar

ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

ENTRYPOINT ["dockerize","-wait","tcp://fca.database:5432", "java", "-jar", "rs-api.jar"]