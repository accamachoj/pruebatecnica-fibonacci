FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn  package

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/fibonacci-0.0.1-SNAPSHOT.jar ./app.jar

RUN mkdir /TempFiles

CMD ["java", "-jar", "app.jar"]