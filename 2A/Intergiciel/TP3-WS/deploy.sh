#!bin/bash

PROJECT_NAME=$1
PROJECT_PATH=./$PROJECT_NAME
TOMCAT_WEBAPP_PATH=./apache-tomcat-ws/webapps

if [ -z "$PROJECT_PATH" ] && [ ! -d "$PROJECT_PATH" ]; then
    echo "Usage: deploy.sh <project_name>\nEt genre faut que le terminal soit dans le dossier avec les projets parce que flemme de faire plus propre"
    exit 1
fi

mv $PROJECT_PATH/WebContent/* $TOMCAT_WEBAPP_PATH/$PROJECT_NAME
zip -r $TOMCAT_WEBAPP_PATH/$PROJECT_NAME.war $TOMCAT_WEBAPP_PATH/$PROJECT_NAME
