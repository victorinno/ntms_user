FROM openjdk:11

RUN apt-get update && apt-get install -y maven
COPY . /project
WORKDIR project
RUN mvn package

##this part for debug is moved into compose file, into "command":
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/project/target/user-0.0.1-SNAPSHOT.jar"]