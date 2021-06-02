#!/bin/bash

PRG="$0"
PRGDIR=`dirname "$PRG"`

APPNAME=etl-data-service-1.0-SNAPSHOT
pid=`ps -ef | grep java | grep $APPNAME | grep -v grep | grep -v kill | awk '{print $2}'`
tpid=`cat "$PRGDIR"/$APPNAME.pid`

if [[ ${pid} && ${pid} -eq ${tpid} ]]; then
    echo -e 'Stop Process.\c'
    kill -15 $pid
fi

retrycnt=60
pid=`ps -ef | grep java | grep $APPNAME | grep -v grep | grep -v kill | awk '{print $2}'`
while [[ $retrycnt -gt 0 && ${pid} ]]; do
        sleep 1
        echo -e '.\c'
        pid=`ps -ef | grep java | grep $APPNAME | grep -v grep | grep -v kill | awk '{print $2}'`
        retrycnt=$((retrycnt - 1))
done

pid=`ps -ef | grep java | grep $APPNAME | grep -v grep | grep -v kill | awk '{print $2}'`
if [[ ${pid} ]]; then
        echo -e '\nTimeout, Kill Process!'
        kill -9 $pid
else
        echo -e '\nStop Success!'
fi
