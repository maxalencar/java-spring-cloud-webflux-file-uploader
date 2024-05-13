# Use an OpenJDK runtime as a base image
FROM openjdk:23-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Spring Boot application JAR file into the container
COPY build/libs/uploader-service-1.0.0.jar uploader-service.jar

# Expose port 2222 to the outside world
EXPOSE 2222

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "uploader-service.jar"]
