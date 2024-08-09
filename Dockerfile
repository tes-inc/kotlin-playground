## Stage 1: Build
#FROM gradle:7.6.1-jdk17 AS build
#COPY --chown=gradle:gradle . /home/gradle/project
#WORKDIR /home/gradle/project
##RUN gradle build --no-daemon
#
## Stage 2: Run
#FROM openjdk:17-jdk-slim
#COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]

## Stage 1: Build
#FROM gradle:7.6.1-jdk17 AS build
#COPY --chown=gradle:gradle . /home/gradle/project
#WORKDIR /home/gradle/project
#RUN gradle clean build --no-daemon -x test
#
## Stage 2: Run
#FROM openjdk:17-jdk-slim
#COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
#WORKDIR /home/gradle/project
#ENTRYPOINT ["java", "-Dspring.devtools.restart.enabled=true", "-jar", "/app.jar"]

# Stage 1: Build
#FROM gradle:7.6.1-jdk17 AS build
#COPY --chown=gradle:gradle . /home/gradle/project
#WORKDIR /home/gradle/project
#RUN gradle clean build --no-daemon -x test

# Stage 2: Run
#FROM openjdk:17-jdk-slim
#COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
#WORKDIR /home/gradle/project
#ENTRYPOINT ["java", "-Dspring.devtools.restart.enabled=true", "-jar", "/app.jar"]

FROM gradle:7.6.1-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project

# Fetch project dependencies
RUN chmod +x start.sh && ./gradlew getDependencies

# script which watches source file changes in background and executes bootRun
CMD ["sh", "start.sh"]
