# Usa uma imagem oficial do Java 17
FROM eclipse-temurin:17-jdk-jammy

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos de configuração do Maven usando o nome exato da pasta
COPY "organização igreja/.mvn/" .mvn/
COPY "organização igreja/mvnw" "organização igreja/pom.xml" ./
RUN ./mvnw dependency:go-offline

# Copia o código fonte da pasta correta
COPY "organização igreja/src" ./src

# Compila o projeto gerando o arquivo .jar
RUN ./mvnw clean package -DskipTests

# Expõe a porta do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["sh", "-c", "java -jar target/*.jar"]
