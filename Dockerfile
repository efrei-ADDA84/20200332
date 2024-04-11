FROM maven:3.8.4-openjdk-17-slim AS build-n-push
WORKDIR /app
COPY pom.xml .
RUN mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline
COPY src src
RUN mvn -B -e -C -T 1C package

FROM openjdk:17-jdk
COPY --from=build-n-push /app/target/devops-0.0.1-SNAPSHOT.jar /app/DevopsApplication.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/DevopsApplication.jar"]
LABEL authors="timot"
