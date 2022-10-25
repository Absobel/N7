#!/bin/sh
        #la ligne dessus indique l'interpréteur qui exécutera ce shell
        #sinon il faudrait l'exécuter avec : sh lsalles.sh
for num in `seq 1 16`  #pour toutes les valeurs entre 1 et 16
        #seq 1 16 doit être encadré par des backquotes (accessibles avec Altgr+7)
do
  if [ $num -gt 9 ]    #si num > 9 / attention aux espaces entre les [ ]
  then
	mac="C201-$num"
  else
	mac="C201-0$num"
  fi                   #mac aura les valeurs c201-01 ...c201-16
  echo $mac	
done
