WILDFLY=/opt/wildfly
WEB_PATH=/home/absobel/Mir/GitRepos/N7/2A/Web
CMD_WILDFLY="alacritty -e $WILDFLY/bin/standalone.sh"
CMD_DB="alacritty --working-directory $WEB_PATH/db -e ant start"

pkill -f "$CMD_WILDFLY"
pkill -f "$CMD_DB"

rm -dr $WEB_PATH/**/build 2>/dev/null
rm -dr $WEB_PATH/**/WebContent/WEB-INF/classes 2>/dev/null
fd -E README.txt . $WILDFLY/standalone/deployments -x rm   
