FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER "Mikoto <1210382799@qq.com>"
LABEL description="个人博客后台"
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime \
WORKDIR app
ADD  target/blog-latest.jar /app/app.jar
EXPOSE 8080
CMD java -jar /app/app.jar