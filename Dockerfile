# Build stage:
#

FROM maven:3.8.3-openjdk-11 AS BUILD
WORKDIR /app
COPY . /app/
RUN mvn clean package

# Package stage
FROM openjdk:11
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar", "app.jar"]
