FROM java:8u111-jdk
# time zone
RUN echo "Asia/Chongqing" > /etc/timezone && dpkg-reconfigure -f noninteractive tzdata
RUN mkdir /app
RUN mkdir /app/logs
ADD app.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
RUN bash -c 'touch /app/app.jar'
WORKDIR /app
