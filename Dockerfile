FROM maven:3.6.3-jdk-11

VOLUME /tmp
RUN mkdir -p /itau

COPY . /itau
RUN cd itau && mvn clean install

ENV PROFILE sandbox

EXPOSE 8080

RUN  ln -sf /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime
CMD  java   -Duser.timezone=America/Sao_Paulo -Xms200m -Xmx200m -Dspring.profiles.active=$PROFILE \
            -Djava.security.egd=file:/dev/./urandom \
            -jar /itau/target/backend-challenge-0.0.1-SNAPSHOT.jar
