FROM registry-internal.cn-shanghai.aliyuncs.com/mikoto/blog-backstage
ADD . /app
WORKDIR /app/
RUN mvn clean package
EXPOSE 8080
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar target/tim-sign-fys-0.0.1-SNAPSHOT.jar