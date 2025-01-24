#!/bin/bash

usage() {
    echo "Usage: $0 <ssh/local>"
    exit 1
}

if [[ $0 != "scripts/deploy.sh" && $0 != "./scripts/deploy.sh" ]]; then
    echo "Please run this script from the root of the project"
    usage  
    exit 1
fi

if [ $# -ne 1 ] || { [ "$1" != "ssh" ] && [ "$1" != "local" ]; }; then
    usage
    exit 1
fi

## HDFS 
# Compilation
rm -rf bin # c'est hyper moche et lent mais sans ça ça marche pas
mkdir bin
fd .java src | xargs javac -d bin -cp "lib/*"

cd bin
for file in ../lib/*.jar; do
  jar xf "$file"
done
cd ..

rm -rf target
mkdir target
jar --create --file target/HdfsClient.jar --main-class hdfs.HdfsClient -C bin hdfs/ -C bin config/ -C bin org
jar --create --file target/HdfsServer.jar --main-class hdfs.HdfsServer -C bin hdfs/ -C bin config/ -C bin org
jar --create --file target/HagidoopClient.jar --main-class daemon.HagidoopClient -C bin daemon/ -C bin config/ -C bin interfaces/ -C bin application/ -C bin org
jar --create --file target/HagidoopServer.jar --main-class daemon.HagidoopServer -C bin daemon/ -C bin config/ -C bin interfaces/ -C bin application/ -C bin org

# Configuration
NB_OF_SERV=$(jq -r '.nb_of_servers' config/config.json)
HDFS_BASE_PORT=$(jq -r '.base_port' config/config.json)
HAGIDOOP_BASE_PORT=$(jq -r '.hagidoop_base_port' config/config.json)

# Deployment
HOSTNAMES_FILEPATH="target/hostnames.txt"
if [ "$1" = "local" ]; then
    ps -ax | grep "java -jar" | head -n $((2*$NB_OF_SERV)) | awk '{print $1}' | xargs kill 2> /dev/null
fi

for i in $(seq 1 $NB_OF_SERV); do
    HDFS_PORT=$(($HDFS_BASE_PORT + $i - 1))
    HAGIDOOP_PORT=$(($HAGIDOOP_BASE_PORT + $i - 1))

    if [ "$1" = "ssh" ]; then
        HOSTNAME=$(sed "${i}q;d" config/ssh_hosts.txt)
        echo "$HOSTNAME:$HDFS_PORT" >> $HOSTNAMES_FILEPATH
        # TODO
    else
        echo "localhost:$HDFS_PORT" >> $HOSTNAMES_FILEPATH
        java -jar target/HdfsServer.jar $HDFS_PORT > target/hdfs_log$i.txt 2>&1 &
        java -jar target/HagidoopServer.jar $HAGIDOOP_PORT > target/hagidoop_log$i.txt 2>&1 &
    fi
done