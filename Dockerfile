# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory to the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/Player.csv src/main/resources/Player.csv

# Expose the port your Spring Boot app listens on (typically 8080)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

