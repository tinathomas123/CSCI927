FROM maven:3.8.3-openjdk-17 AS build
COPY room-booking/dates/src /home/app/src
COPY room-booking/dates/pom.xml /home/app
ADD room-booking/dates/target/dates-0.0.1-SNAPSHOT.jar dates.jar
EXPOSE 7000
ENTRYPOINT ["java","-jar","dates.jar"]