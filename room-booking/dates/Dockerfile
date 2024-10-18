FROM maven:3.8.3-openjdk-17 AS build
COPY dates/src /home/app/src
COPY dates/pom.xml /home/app
ADD dates/target/dates-0.0.1-SNAPSHOT.jar dates.jar
EXPOSE 7000
ENTRYPOINT ["java","-jar","dates.jar"]