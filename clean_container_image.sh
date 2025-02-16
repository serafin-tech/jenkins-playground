#!/bin/bash

CONTAINER_NAME="jenkins-jenkins-1"
IMAGE_NAME="jenkins-jenkins"

docker container rm "${CONTAINER_NAME}" 

docker image rm "${IMAGE_NAME}"
