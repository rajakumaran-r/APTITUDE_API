FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy the whole project
COPY . .

# Build the JAR inside Docker
RUN ./mvnw clean package -DskipTests

# Copy the built JAR to a clean image (optional multi-stage for smaller image)
# Or just run directly
ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "target/AptitudeAPI-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
