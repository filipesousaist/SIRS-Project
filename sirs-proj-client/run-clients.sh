#!/bin/bash

for x in {1..19..2}
do
   java -jar target/sirs-proj-client-0.0.1-SNAPSHOT-jar-with-dependencies.jar "$x" "$x" 1 SV 1
done

for x in {2..20..2}
do
   java -jar target/sirs-proj-client-0.0.1-SNAPSHOT-jar-with-dependencies.jar "$x" "$x" 2 SV 1
done

