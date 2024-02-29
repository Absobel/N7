#!/bin/bash

make clean;
mkdir $USER
cp -r array_sum barber_shop count_type inplace_cast tree_dist $USER;
cd $USER; find . -not \( -name  "*.c" -or  -name "Makefile" -or -name "*.h" -or -type d \) | xargs rm; cd ..;
tar zcvf $USER.tgz $USER;
rm -rf $USER;
