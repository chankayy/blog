FROM java:8
# time zone
RUN mkdir /app
RUN mkdir /app/logs
COPY ./blog_jar /app
ENTRYPOINT ["java","-jar","blog.jar"]
WORKDIR /app