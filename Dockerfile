FROM eclipse-temurin:21-jre-alpine

ENV APP_NAME bcnc

COPY ./target/bcnc.jar /app/bcnc.jar

WORKDIR /app

CMD sh -c "java -jar ${APP_NAME}.jar"

EXPOSE 8080
