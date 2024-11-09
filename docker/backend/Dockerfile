# Build Stage
FROM maven:3.6-openjdk-17-slim AS build
WORKDIR /build
# . refere to the working directory 'build'
COPY pom.xml .
# downloads all dependencies during the image build process.
# This way, when you later run the container and build your project,
# Maven doesn’t need to re-download dependencies each time,
# which can significantly improve build times in CI/CD pipelines
RUN mvn dependency:go-offline
COPY src ./src
# we skip test to make the application build faster
RUN mvn clean package -DskipTests

# Runtime Stage
FROM amazoncorretto:17 AS runtime
WORKDIR /app
COPY --from=build /build/target/productService-*.jar .
# port on which application runs
# define some variable with default values to assign to ENV
# this is because we can not use it directly with CMD or ENTRYPOINT
# SPACES are not allowed in ENV and ARG
ARG APP_PROFILE=local
ARG APP_VERSION=1.0.0
# define env variables
ENV ACTIVE_PROFILE=${APP_PROFILE}
ENV JAR_VERSION=${APP_VERSION}
ENV DB_CONTAINER_NAME=postgres
ENV DB_PORT=5432
# instead of localhost use db container name
ENV DB_URL="jdbc:postgresql://${DB_CONTAINER_NAME}:${DB_PORT}/product_db"
EXPOSE 8081
# this command is executed when we run the container not while building the image
# there must be a space between ENRYPOINT and [
# and it must be written in a single line or use \ to split it to multiple line
# if we want to user env with ENTRYPOINT then we need to use shell style instead of json one
# this will not work
#ENTRYPOINT ["java", "-jar", \
#            "-Dspring.profiles.active=${ACTIVE_PROFILE}", \
#            "-Dspring.datasource.url=${DB_URL}", \
#            "productService-${JAR_VERSION}.jar"]
ENTRYPOINT java -jar -Dspring.profiles.active=${ACTIVE_PROFILE} \
            -Dspring.datasource.url=${DB_URL} \
            productService-${JAR_VERSION}.jar
# use this command to build the image
# docker build -t akhatab/product-service:1.0.0 -f docker/backend/Dockerfile .
# VIP:
# When building the Docker image, set the build context to the root directory of the project
# so Docker has access to src

