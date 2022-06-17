FROM openjdk:8
ADD target/UserFrontAPI.jar UserFrontAPI.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "UserFrontAPI.jar"]