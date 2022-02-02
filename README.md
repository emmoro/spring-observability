## Spring boot with gradle using observability(Prometheus and Grafana)

Project in Spring Boot with gradle, using observability(Prometheus and Grafana) and creation custom metrics

## Tools used in project
* Java 11
* Gradle
* IDE was used Intellij.
* Using JVM (Micrometer) to generate information about JVM in Graphics Grafana(Extension JVM (Micrometer) - Grafana - https://grafana.com/grafana/dashboards/4701)


## Getting Started
* Necessary install Prometheus and Grafana or use the container docker
* After this, if you install docker, you can execute: "docker-compose up" to start Prometheus and Grafana
* After you can start the project

## Address to Access
* Access the address the project: http://localhost:8180/api/
* Access the address the Prometheus: http://localhost:9090/
* Access the address the Prometheus: http://localhost:3000/ (user and password: admin)
* Access the address the Actuator: http://localhost:8180/actuator/ (remembering that there are countless variables to access within the actuator, example: actuator/prometheus, 
  actuator/prometheus, actuator/health, actuator/info ...)