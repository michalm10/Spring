#!/bin/sh

java -cp ./hsqldb.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 workdb1
