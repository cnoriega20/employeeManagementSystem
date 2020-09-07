FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.jar
ARG user=cnor20
ARG group=springdev
ARG uid=1000
ARG gid=1000
COPY ${JAR_FILE} springbootRestApi.jar
RUN groupadd -g ${gid} ${group} && useradd -u ${uid} -g ${group} -s /bin/sh ${user}
ENTRYPOINT ["java","-jar","/springbootRestApi.jar"]