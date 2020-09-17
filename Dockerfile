FROM maven AS build
COPY . /home/app
WORKDIR /home/app
RUN mvn package

FROM openjdk:8-jre-alpine
COPY --from=build /home/app/target/test202001-*.jar /usr/local/lib/app.jar
COPY dataset/data.sqlite /usr/local/lib/dataset/data.sqlite
EXPOSE 8080
CMD java -jar /usr/local/lib/app.jar