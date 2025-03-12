# Use Java 21 for building the project
FROM eclipse-temurin:21 AS builder  

WORKDIR /app
COPY . /app

RUN chmod +x ./mvnw && ./mvnw -B -DskipTests clean install

# Use a lightweight JDK runtime for running the application
FROM eclipse-temurin:21-jre AS runtime  

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
