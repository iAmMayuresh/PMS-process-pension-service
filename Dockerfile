FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD "target/process-pension-service.jar" "process-pension-service.jar"
ENTRYPOINT [ "java", "-jar", "/process-pension-service.jar" ]