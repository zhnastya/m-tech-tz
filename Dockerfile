FROM openjdk:17-oracle
ARG JAR_FILE=target/tech-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
EXPOSE 8080
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
