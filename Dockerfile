FROM ubuntu:latest
COPY bin/demo/DemoHttpServerBySocket.class bin/demo/DemoHttpServerBySocket.class
COPY www/ www/ 
RUN apt-get update && apt-get install -y default-jre && apt-get install -y default-jdk
WORKDIR bin
RUN java demo.DemoHttpServerBySocket