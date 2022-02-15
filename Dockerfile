FROM openjdk:8u191-jre-alpine3.8

#install on base images
RUN apk add curl jq

#workspace
WORKDIR /usr/sumit/docker-selenium

#Add jar files in target location from host

ADD target/selenium-docker.jar 				selenium-docker.jar
ADD target/selenium-docker-tests.jar 		selenium-docker-tests.jar
ADD target/libs								libs

#add any other dependencies like properties file, xls, csv, json files

#Ad suite files
ADD bookflightmodule.xml					bookflightmodule.xml
ADD searchmodule.xml						searchmodule.xml

#Add health check script

Add healthcheck.sh 							healthcheck.sh

#Environment variables - BROWSER, HUB_HOST, MODULE
ENTRYPOINT sh healthcheck.sh