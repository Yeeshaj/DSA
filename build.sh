#!bin/sh

file=$1

javac $file
java $file


find . -type f -name "*.class" -delete
