FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springbootRestApi.jar
ENTRYPOINT ["java","-jar","/springbootRestApi.jar"]