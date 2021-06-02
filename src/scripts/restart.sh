#!/bin/bash

PRG="$0"
PRGDIR=`dirname "$PRG"`

sh $PRGDIR/shutdown.sh
sh $PRGDIR/start.sh
