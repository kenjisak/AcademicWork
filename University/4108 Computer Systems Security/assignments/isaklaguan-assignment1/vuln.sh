#!/bin/bash

DEBUG_FILE=/home/student/.debug_log

rm $DEBUG_FILE

while true
do
  nice -n 20 ./vuln_fast "localhost student"
done
