# Usa uma imagem oficial do Java 17
FROM eclipse-temurin:17-jdk-jammy

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos de configuração do Maven para otimizar o build
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

# Copia todo o código fonte para dentro do container
COPY src ./src

# Compila o projeto gerando o arquivo .jar (ignorando os testes por enquanto)
RUN ./mvnw clean package -DskipTests

# Expõe a porta que o Spring Boot usa
EXPOSE 8080

# Comando para rodar a aplicação (usando * para achar o .jar gerado)
CMD ["java", "-jar", "target/organizacao-igreja-0.0.1-SNAPSHOT.jar"]
