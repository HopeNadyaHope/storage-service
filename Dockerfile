FROM adoptopenjdk/openjdk11:jdk-11.0.5_10-alpine
EXPOSE 8000
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} storage-service.jar
ENTRYPOINT ["java","-jar","/storage-service.jar"]