FROM openjdk:8-jre

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

COPY target/ts-discovery-service-1.0.jar /app/ts-discovery-service-1.0.jar

CMD ["java", "-Xmx200m",  "-jar", "/app/ts-discovery-service-1.0.jar"]

EXPOSE 8761
