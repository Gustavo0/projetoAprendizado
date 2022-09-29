FROM maven:3.6.0-jdk-11-slim AS build
RUN mkdir apps
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/projetoAprendizado.jar
WORKDIR /app
ENTRYPOINT java -jar projetoAprendizado.jar