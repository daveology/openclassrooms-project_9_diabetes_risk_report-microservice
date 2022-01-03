FROM openjdk:8-jdk-alpine

COPY build/libs/openclassrooms_9th-project_report-microservice-0.0.1-SNAPSHOT.jar /Report.jar

CMD ["java", "-jar", "/Report.jar"]
