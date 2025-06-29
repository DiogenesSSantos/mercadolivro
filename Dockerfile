FROM openjdk:21-jdk-slim

WORKDIR /home/diogenes

COPY build/libs/api.jar api.jar

EXPOSE 8080
CMD ["java", "-jar", "api.jar"]