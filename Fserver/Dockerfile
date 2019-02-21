FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD target/fserver-0.0.1-SNAPSHOT.jar fserver-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","fserver-0.0.1-SNAPSHOT.jar"]