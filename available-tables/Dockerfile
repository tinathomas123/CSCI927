FROM maven:3.8.3-openjdk-17 AS build
COPY available-tables/src /home/app/src
COPY available-tables/pom.xml /home/app
ADD available-tables/target/table-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]