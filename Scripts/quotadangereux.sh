#!/bin/bash
if [ $1 ]
then
    pmax=$1
else
    pmax=90
fi
quota -s | grep M | head -1 > fic_quota
sed -i "s/M//g" fic_quota
sed -i "s/\ \ */\ /g" fic_quota
quota=$(cut -f3 -d' ' fic_quota)
volume=$(cut -f2 -d' ' fic_quota)
pct=$(($volume*100/$quota))
if [ $pct -gt $((pmax)) ]
then
    echo $volume $quota $pct%
    echo -e "\e[0;31m!!!ATTENTION : VOLUME DE DONNEES SUPERIEUR A $pmax% DU QUOTA DISQUE\e[0;37m"
fi
