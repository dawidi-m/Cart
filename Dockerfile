FROM openjdk:8
ADD out/artifacts/demo_jar/demo.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]