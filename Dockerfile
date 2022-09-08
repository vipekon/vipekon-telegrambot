FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_vipekon_bot
ENV BOT_TOKEN=5380068074:AAFHznzbKyfnKMAbLNgx0s7D8ZBrjf0Cmyc
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]