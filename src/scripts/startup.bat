echo off

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

title etl-data-service-1.0-SNAPSHOT

java -Xloggc:%APP_HOME%/logs/gc.log -verbose:gc -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=%APP_HOME%/logs -Dlogging.config=%APP_HOME%/config/logback.xml -Dlogging.path=%APP_HOME%/logs -Dspring.config.location=%APP_HOME%/config/application-dev.properties -jar %APP_HOME%/libs/etl-data-service-1.0-SNAPSHOT.jar
