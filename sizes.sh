#!/usr/bin/env bash


NATIVE_SIZE=`ls -lh build/native/nativeCompile/demopacificogradle | awk '{print $5}' | sed 's/M//'`
JAR_SIZE=`ls -lh build/libs/demopacificogradle-0.0.1-SNAPSHOT.jar | awk '{print $5}' | sed 's/M//'`
JDK_IMG_SIZE=`docker inspect -f "{{ .Size }}" localhost/demopacificogradle:jdk.0.0.1-SNAPSHOT | numfmt --to=si | sed 's/.$//'`
NATIVE_IMG_SIZE=`docker inspect -f "{{ .Size }}" localhost/demopacificogradle:native.0.0.1-SNAPSHOT | numfmt --to=si | sed 's/.$//'`
JLINK_IMG_SIZE=`docker inspect -f "{{ .Size }}" localhost/demopacificogradle:jlink.0.0.1-SNAPSHOT | numfmt --to=si | sed 's/.$//'`

# Chart of the image sizes
echo "JAR ${JAR_SIZE}
    Native-Exe ${NATIVE_SIZE}
    NI-Container ${NATIVE_IMG_SIZE}
    JDK-Container ${JDK_IMG_SIZE}
    JLink-Continer ${JLINK_IMG_SIZE}" \
    | termgraph --title "Container Size" --width 60 --color {green,} --suffix " MB"

