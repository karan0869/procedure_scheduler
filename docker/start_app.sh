#!/bin/sh

# startup.sh - startup script for the server docker image

echo "Starting prowatch scheduler v2 application"

/app/prowatch-scheduler-v2/host_entry.sh $HOSTS

LOG_FILE="/app/prowatch-scheduler-v2/log/application-$(date '+%Y-%m-%d_%H-%M-%S').log"

export config_file=/app/prowatch-scheduler-v2/application.properties
#fi
#echo "hosts: $HOSTS"
echo "DB_IP: $DB_IP"
echo "DB_PORT: $DB_PORT"
echo "DB_NAME:           $DB_NAME"
echo "DB_USER:           $DB_USER"
echo "DB_PASS:           $DB_PASS"

sed -i "s;##DB_IP##;$DB_IP;" $config_file
sed -i "s;##DB_PORT##;$DB_PORT;" $config_file
sed -i "s;##DB_NAME##;$DB_NAME;" $config_file
sed -i "s;##DB_USER##;$DB_USER;" $config_file
sed -i "s;##DB_PASS##;$DB_PASS;" $config_file


echo "Using java options config: $JAVA_OPTS"

java ${JAVA_OPTS} -jar  -Dspring.config.location=/app/prowatch-scheduler-v2/application.properties  /app/prowatch-scheduler-v2/api-*-SNAPSHOT.jar 2>&1 | tee -a "$LOG_FILE"
