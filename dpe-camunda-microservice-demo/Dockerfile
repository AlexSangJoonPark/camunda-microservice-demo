FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","$JAVA_OPTS","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar