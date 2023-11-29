#!/bin/bash

#export DB_HOST=localhost

# curl localhost:8080
# curl localhost:8080/actuator/health
# curl localhost:8080/actuator/info
# curl -X POST localhost:8080/actuator/shutdown


# https://spring.io/guides/gs/spring-boot/
# https://spring.io/guides/gs/uploading-files/

export SERVICE_NAME=balance-charger
export SERVICE_VERSION=V-1.0.0

./gradlew bootRun
