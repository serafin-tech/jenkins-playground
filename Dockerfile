FROM jenkins/jenkins:lts

USER root

RUN apt-get update && apt-get install -y lsb-release python3 python3-pip python3-venv

USER jenkins
