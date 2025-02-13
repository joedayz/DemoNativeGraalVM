#!/usr/bin/env bash

REPO=localhost
APP=demopacificogradle
TYPE=jdk
VER=0.0.1-SNAPSHOT
CONTAINER=${REPO}/${APP}:${TYPE}.${VER}
JAR_FILE=demopacificogradle-0.0.1-SNAPSHOT.jar

echo "Container : ${CONTAINER}"

echo "Building Java..."

gradle build -x test

echo "DONE"

echo "Dockerizing our app.."

docker login container-registry.oracle.com

docker build -f Dockerfile.jdk \
             --build-arg JAR_FILE=${JAR_FILE} \
             -t ${CONTAINER} .
echo "DONE"