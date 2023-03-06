FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x ./mvnw

RUN ./mvnw -f /workspace/app/pom.xml clean package -Dmaven.test.skip

FROM eclipse-temurin:17-jdk-alpine

RUN addgroup -S demo && adduser -S demo -G demo
USER demo

WORKDIR /app

EXPOSE 8000

COPY --from=build /workspace/app/target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
