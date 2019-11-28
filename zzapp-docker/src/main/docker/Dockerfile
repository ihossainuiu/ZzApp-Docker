FROM tomcat:8.5-alpine
WORKDIR /app
VOLUME ["/app"]
COPY maven/app.war app.war
COPY maven/start.sh start.sh
COPY maven/wait-for-it.sh wait-for-it.sh

RUN sh -c 'touch app.war'
ENTRYPOINT ["./start.sh"]
