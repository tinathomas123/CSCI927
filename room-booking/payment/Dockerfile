FROM maven:3.8.3-openjdk-17 AS build
COPY payment/src /home/app/src
COPY payment/pom.xml /home/app
ADD payment/target/payment-0.0.1-SNAPSHOT.jar payment.jar
EXPOSE 7001
ENTRYPOINT ["java","-jar","payment.jar"]