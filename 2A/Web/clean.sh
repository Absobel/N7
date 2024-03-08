rm -dr **/build
rm -dr **/WebContent/WEB-INF/classes
fd -E README.txt . /opt/wildfly/standalone/deployments -x rm   
