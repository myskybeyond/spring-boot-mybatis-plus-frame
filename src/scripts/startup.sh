#!/bin/bash

PRG="$0"
SAVED="`pwd`"
cd "`dirname \"$PRG\"`/.." >/dev/null
APP_HOME="`pwd -P`"
cd "$SAVED" >/dev/null

 java -Xloggc:$APP_HOME/logs/gc.log \
	-verbose:gc -XX:+PrintGCDetails \
	-XX:+HeapDumpOnOutOfMemoryError \
	-XX:HeapDumpPath=$APP_HOME/logs \
	-Dlogging.config=$APP_HOME/config/logback.xml \
	-Dlogging.path=$APP_HOME/logs \
	-Dspring.config.location=$APP_HOME/config/application.properties \
	-jar $APP_HOME/libs/etl-data-service-1.0-SNAPSHOT.jar
