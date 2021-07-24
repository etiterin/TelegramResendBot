# syntax=docker/dockerfile:1

FROM openjdk:8-jdk-alpine
EXPOSE 8080

WORKDIR /app

COPY . /app

CMD ["./gradlew", "run"]




