# Build stage
FROM maven:3.9.9-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies first (cache optimization)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the application (skip tests to speed up build)
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre

# Set working directory
WORKDIR /app

# Copy the jar from build stage
COPY --from=build /app/target/user-service-0.0.1-SNAPSHOT.jar app.jar

# Expose port (update to your application port, default 8081)
EXPOSE 8081

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
