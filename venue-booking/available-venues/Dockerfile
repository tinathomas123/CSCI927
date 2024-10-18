FROM maven:3.8.3-openjdk-17 AS build
COPY venue-booking/available-venues/src /home/app/src
COPY venue-booking/available-venues/pom.xml /home/app
ADD venue-booking/available-venues/target/venue-booking-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]