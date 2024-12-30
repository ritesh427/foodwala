# Use a Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Label for authors
LABEL authors="Ritesh"

# Set the working directory
WORKDIR /opt

# Copy the built Spring Boot application JAR into the container
COPY target/*.jar /opt/app.jar

# Define the entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
