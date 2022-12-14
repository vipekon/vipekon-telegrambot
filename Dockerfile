FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test.vipekon_bot
ENV BOT_TOKEN=5380068074:AAFHznzbKyfnKMAbLNgx0s7D8ZBrjf0Cmyc
ENV BOT_DB_USERNAME=vipekontb_db_user
ENV BOT_DB_PASSWORD=vipekontb_db_pass
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "app.jar"]