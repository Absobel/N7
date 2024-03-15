#!/bin/bash

WILDFLY=/opt/wildfly
WEB_PATH=/home/absobel/Mir/GitRepos/N7/2A/Web

if [[ $(pwd) != "$WEB_PATH" ]]; then
    echo "Met toi dans le bon directory tocard"
    exit 1
fi

CMD_WILDFLY="alacritty -e $WILDFLY/bin/standalone.sh"
CMD_DB="alacritty --working-directory $WEB_PATH/db -e ant start"

pkill -f "$CMD_WILDFLY"
pkill -f "$CMD_DB"

owner=$(stat -c "%U" $WILDFLY)
if [[ "$owner" != "$USER" ]]; then
    sudo chown -R "$USER":"$USER" "$WILDFLY"
fi

eval $CMD_WILDFLY &

if [ ! -d ./db ]; then
    FLAG=1
    wget -P /tmp https://sd-160040.dedibox.fr/hagimont/software/db.tgz
    tar -xvf /tmp/db.tgz
    cd $WEB_PATH/db/
fi

eval $CMD_DB &

if [ -n "$FLAG" ]; then
    ant db1
    #ant db2
fi
