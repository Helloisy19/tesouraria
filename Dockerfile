FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY igrejah/.mvn/ .mvn/
COPY igrejah/mvnw igrejah/pom.xml ./
RUN ./mvnw dependency:go-offline
COPY igrejah/src ./src
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["sh", "-c", "java -jar target/*.jar"]
