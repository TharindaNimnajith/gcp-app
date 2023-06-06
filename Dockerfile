# https://spring.io/guides/topicals/spring-boot-docker/

# ./gradlew build

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# docker build --build-arg JAR_FILE=build/libs/*.jar -t myorg/myapp .
