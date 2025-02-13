#!/usr/bin/env bash

REPO=localhost
APP=demopacificogradle
TYPE=native
VER=0.0.1-SNAPSHOT
CONTAINER=${REPO}/${APP}:${TYPE}.${VER}
JAR_FILE=demopacificogradle-0.0.1-SNAPSHOT.jar

echo "Container : ${CONTAINER}"

echo "Building Java..."

gradle build -x test nativeCompile

echo "DONE"

echo "Dockerizing our app.."

docker login container-registry.oracle.com

docker build -f Dockerfile.native \
             --build-arg APP_FILE=${APP_FILE} \
             -t ${CONTAINER} .

echo "DONE"