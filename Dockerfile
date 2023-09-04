FROM openjdk:latest
ARG JAR_FILE=target/*.jar
COPY ./target/tech-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java" , "-jar" , "/app.jar"]