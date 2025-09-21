FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the whole project
COPY . .

# Install Maven (if not available) or assume system Maven
RUN apt-get update && apt-get install -y maven

# Build the JAR
RUN mvn clean package -DskipTests

# Run the JAR
ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "target/AptitudeAPI-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
