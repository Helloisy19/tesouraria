FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY organizacao-igreja/.mvn/ .mvn
COPY organizacao-igreja/mvnw organizacao-igreja/pom.xml ./
RUN ./mvnw dependency:go-offline
COPY organizacao-igreja/src ./src
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["sh", "-c", "java -jar target/*.jar"]