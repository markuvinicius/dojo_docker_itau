FROM java:8-jdk-alpine
LABEL maintainer 'Marku Vinicius <markuvinicius@gmail.com>'

WORKDIR /app
COPY ./ /app

ARG AWS_ACCESS_KEY_ID
ARG AWS_SECRET_ACCESS_KEY

ENV AWS_ACCESS_KEY_ID $AWS_ACCESS_KEY_ID
ENV AWS_SECRET_KEY $AWS_SECRET_ACCESS_KEY

COPY ./target/twitter*.jar /usr/app/app.jar
WORKDIR /usr/app

ENTRYPOINT ["java","-jar","app.jar"]