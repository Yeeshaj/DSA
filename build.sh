#!bin/sh

file=$1

javac $file
java $file

name=${file%.java}

rm -rf $name.class