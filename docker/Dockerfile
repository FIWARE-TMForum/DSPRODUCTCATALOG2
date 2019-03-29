FROM ubuntu:16.04

RUN apt-get update; \
    apt-get install -y --fix-missing python2.7 net-tools vim python-pip git wget curl unzip maven mysql-client openjdk-8-jdk; \
    wget http://download.java.net/glassfish/4.1/release/glassfish-4.1.zip; \
    unzip glassfish-4.1.zip; \
    pip install sh; \
    wget http://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-5.1.39.tar.gz; \
    tar -xvf mysql-connector-java-5.1.39.tar.gz; \
    cp ./mysql-connector-java-5.1.39/mysql-connector-java-5.1.39-bin.jar glassfish4/glassfish/domains/domain1/lib; \
    mkdir /catalog; \
    mkdir -p /etc/default/tmf/

COPY ./deploy.sh /

VOLUME ["/catalog", "/etc/default/tmf/"]

EXPOSE 8080 4848

HEALTHCHECK CMD curl --fail http://localhost:8080/DSProductCatalog/api/catalogManagement/v2/category || exit 1

CMD while true; do sleep 1000; done
