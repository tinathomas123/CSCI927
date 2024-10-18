FROM maven:3.8.3-openjdk-17 AS build
COPY room-booking/available-rooms/src /home/app/src
COPY room-booking/available-rooms/pom.xml /home/app
ADD room-booking/available-rooms/target/room-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]