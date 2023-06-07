# Use the official Gradle image as the build stage
FROM gradle:jdk17-alpine AS build

# Set the working directory in the container
WORKDIR /workspace

# Copy the entire project directory to the container
COPY . .

# Build the application using Gradle
RUN gradle build

# Use the JDK Alpine base image for the runtime stage
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /workspace/build/libs/*.jar app.jar

# Expose the port that the Spring Boot application listens on
EXPOSE 8080

# Set the command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
