FROM tomcat:8.5-alpine
WORKDIR /app
VOLUME ["/app"]
COPY maven/app.war app.war
COPY maven/start.sh start.sh
COPY maven/wait-for-it.sh wait-for-it.sh
COPY maven/backup.sh backup.sh
COPY maven/pg_backup.sh pg_backup.sh
COPY maven/pg_backup.config pg_backup.config

RUN sh -c 'touch app.war'
ENTRYPOINT ["./start.sh", "./backup.sh"]
