#!/bin/bash

PRGDIR=`dirname "$PRG"`
APPNAME=etl-data-service-1.0-SNAPSHOT

PRG="$0"
SAVED="`pwd`"
cd "`dirname \"$PRG\"`/.." >/dev/null
APP_HOME="`pwd -P`"
cd "$SAVED" >/dev/null

[[ ! -d "$PRGDIR/logs" ]] && mkdir "$PRGDIR/logs"

pid=`ps -ef | grep java|grep $APPNAME | grep -v grep | grep -v kill | awk '{print $2}'`

if [ ${pid} ]; then
    echo 'Application already running!!!'
else

        nohup java -Xloggc:$APP_HOME/logs/gc.log -verbose:gc -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$APP_HOME/logs -Dlogging.config=$APP_HOME/config/logback.xml -Dlogging.path=$APP_HOME/logs -Dspring.config.location=$APP_HOME/config/application.properties -jar $APP_HOME/libs/$APPNAME.jar 1>/dev/null 2>&1 &

        echo $! > $PRGDIR/$APPNAME.pid

        echo 'Start Success!'
fi
