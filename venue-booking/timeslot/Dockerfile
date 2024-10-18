FROM maven:3.8.3-openjdk-17 AS build
COPY timeslot/src /home/app/src
COPY timeslot/pom.xml /home/app
ADD timeslot/target/timeslot-0.0.1-SNAPSHOT.jar timeslot.jar
EXPOSE 7000
ENTRYPOINT ["java","-jar","timeslot.jar"]