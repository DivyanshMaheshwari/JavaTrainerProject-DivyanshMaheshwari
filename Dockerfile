FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080 9092

ENTRYPOINT ["sh", "-c", "java -cp app.jar org.h2.tools.Server -tcp -tcpAllowOthers & java -DwebAllowOthers=true -jar app.jar"]
