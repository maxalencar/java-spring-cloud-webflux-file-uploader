# Use an OpenJDK runtime as a base image
FROM openjdk:23-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Spring Boot application JAR file into the container
COPY build/libs/gateway-service-1.0.0.jar gateway-service.jar

# Expose port 8090 to the outside world
EXPOSE 8090

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "gateway-service.jar"]
