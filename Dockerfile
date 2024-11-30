FROM maven:3.9.5-eclipse-temurin-21 AS build

WORKDIR /app

COPY /api-rest/pom.xml ./api-rest/pom.xml
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY /api-rest/src ./api-rest/src
RUN mvn clean package -DskipTests

#------------------------------------------------
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/api-rest/target/*.jar agenda-pro.jar

EXPOSE 9999
CMD ["java", "-jar", "agenda-pro.jar"]