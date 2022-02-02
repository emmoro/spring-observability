FROM openjdk:11-jre

COPY ./build/libs/app-*.jar ./app-observability.jar

EXPOSE 8180

ENTRYPOINT ["java","-jar","app-observability.jar"]