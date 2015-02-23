#!/bin/bash

THIS_SCRIPT=$0
COMMAND=$1

PROGRAM_NAME="Spring Boot Samples in Branches"
PROGRAM_OUTPUT_FILE=application.out

JAR_PATH=build/libs/samples-spring-boot-branches-1.0.0.jar

PID_FILE=application.pid

function start() {
    if [ -e $PID_FILE ]
    then
        echo "Already started!"
        exit 1
    fi

    echo "Starting ${PROGRAM_NAME}..."

    java -jar $JAR_PATH > $PROGRAM_OUTPUT_FILE 2>&1 &
}

function stop() {
    if ! [ -e $PID_FILE ]
    then
        echo "Already stopped!"
        exit 1
    fi

    echo "Stopping ${PROGRAM_NAME}..."

    kill -TERM `cat $PID_FILE`
}

function usage() {
    echo "Usage: $THIS_SCRIPT <start|stop>"
    exit 1
}

if [ "$COMMAND" == "start" ]
then
    start
    exit 0
elif [ "$COMMAND" == "stop" ]
then
    stop
    exit 0
fi

usage