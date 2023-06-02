FROM maven:latest

RUN mkdir -p /opt/app

RUN mkdir -p /uploads

COPY ./target/soro-0.0.1-SNAPSHOT.war /opt/app

CMD ["java", "-jar", "/opt/app/soro-0.0.1-SNAPSHOT.jar"]