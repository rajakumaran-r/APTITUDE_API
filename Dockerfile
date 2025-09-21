FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the whole project
COPY . .

# Give execute permission to mvnw
RUN chmod +x mvnw

# Build the JAR
RUN ./mvnw clean package -DskipTests

# Run the JAR
ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "target/AptitudeAPI-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
