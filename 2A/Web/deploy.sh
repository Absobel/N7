#!/bin/bash

set -e

if [[ $# != 1 ]] then
    echo "usage : ./deploy.sh <project>"
fi
cd $1

PROJECT_NAME=$(basename $(pwd))

mkdir -p "build"
mkdir -p "WebContent/WEB-INF/classes"
javac -classpath "WebContent/WEB-INF/lib/*" "src/pack/Serv.java" -d "WebContent/WEB-INF/classes"
jar -cvf "build/$PROJECT_NAME.war" -C "WebContent/" .
cp "build/$PROJECT_NAME.war" "/opt/wildfly/standalone/deployments/"
