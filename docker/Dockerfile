# Use a verified and stable base image from Eclipse Temurin (official OpenJDK builds)
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app/prowatch-scheduler-v2

# Copy application files
COPY ./api/target/*.jar /app/prowatch-scheduler-v2/
#COPY ./api/src/main/resources/message.properties /app/prowatch-core-v2/
COPY ./api/docker/host_entry.sh /app/prowatch-scheduler-v2/
COPY ./api/docker/start_app.sh /app/prowatch-scheduler-v2/
COPY ./api/docker/application.properties /app/prowatch-scheduler-v2/

# Grant execute permission to shell scripts
RUN chmod +x /app/prowatch-scheduler-v2/*.sh

# Expose application port
EXPOSE 8083

# Start the app
ENTRYPOINT ["/bin/sh", "/app/prowatch-scheduler-v2/start_app.sh"]
