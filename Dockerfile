FROM eclipse-temurin:17
COPY target/AngularApp.jar AngularApp.jar
CMD ["java", "-jar", "AngularApp.jar"]