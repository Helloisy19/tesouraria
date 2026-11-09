# Usa uma imagem oficial do Java 17
FROM eclipse-temurin:17-jdk-jammy

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos de configuração do Maven de dentro da pasta organizacao-igreja
COPY organizacao-igreja/.mvn/ .mvn
COPY organizacao-igreja/mvnw organizacao-igreja/pom.xml ./
RUN ./mvnw dependency:go-offline

# Copia todo o código fonte de dentro da pasta organizacao-igreja
COPY organizacao-igreja/src ./src

# Compila o projeto gerando o arquivo .jar
RUN ./mvnw clean package -DskipTests

# Expõe a porta do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["sh", "-c", "java -jar target/*.jar"]
