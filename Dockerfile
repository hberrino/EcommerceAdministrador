FROM eclipse-temurin:17-jdk

ARG JAR_FILE=target/ecadm-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app_admecommerce.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app_admecommerce.jar"]
