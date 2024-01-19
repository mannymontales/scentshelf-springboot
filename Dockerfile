FROM amazoncorretto:17

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ScentShelf-SpringBoot.jar

ENTRYPOINT ["java","-jar","/ScentShelf-SpringBoot.jar"]
