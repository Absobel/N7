gnatmake evaluer_alea_lca.adb
gnatmake evaluer_alea_th.adb

rm resultats.txt
touch resultats.txt
for i in 10000 100000 10000000
do
    echo "> ./evaluer_alea_lca 1000 $i" >> resultats.txt
    { time ./evaluer_alea_lca 1000 $i; } >> resultats.txt 2>&1
    echo "" >> resultats.txt
    echo "> ./evaluer_alea_th 1000 $i" >> resultats.txt
    { time ./evaluer_alea_th 1000 $i; } >> resultats.txt 2>&1
    echo -e "\n" >> resultats.txt
done 