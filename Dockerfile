FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/TransactionsApi-0.0.1.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","TransactionsApi-0.0.1.jar"]