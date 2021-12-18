#FROM --platform=linux/amd64 adoptopenjdk/openjdk11:alpine-jre
FROM --platform=linux/arm64/v8 bellsoft/liberica-openjdk-alpine-musl:11
RUN apk --no-cache add curl && apk add --no-cache bash
ARG JAR_FILE=./build/libs/service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app/spring-boot-application.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Dfile.encoding=UTF-8","-jar","/app/spring-boot-application.jar"]