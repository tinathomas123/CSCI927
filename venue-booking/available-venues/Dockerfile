FROM maven:3.8.3-openjdk-17 AS build
COPY available-venues/src /home/app/src
COPY available-venues/pom.xml /home/app
ADD available-venues/target/venue-booking-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]