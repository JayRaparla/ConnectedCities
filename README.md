# connectedCities

## It has the following features

1. Spring Boot 2.0 application with Angular Ui
2. Swagger for API
3. Spring Security configured
4. Testing and reports
5. Dev and prod Spring profiles
6. Internationalisation support
7. Code quality with Sonar
8. Docker configured

It can also easily be converted to a microservice application.

## Pre-requisites :

Before you can run this app, you must install and configure the following dependencies on your machine:

1. [Java 8][]
2. [Node.js][]

## Run the following commands in a terminal to test the application.

1.  Start application (dev profile): `./mvnw`
    Test the endpoints
    . http://127.0.0.1:8080/api/connected/?origin=boston&destination=newark
    . http://127.0.0.1:8080/api/connected/listConnectedCities
    . AND http://127.0.0.1:8080 for UI and navigation.
2.  Build with production profile: `./mvnw -Pprod clean package`
3.  run with production profile : `java -jar target/*.war`
4.  run server tests : `./mvnw clean test`
5.  run client tests : `npm test`
6.  Sonar is used to analyse code quality. You can start a local Sonar server (accessible on http://localhost:9001) with:
    ```
    docker-compose -f src/main/docker/sonar.yml up -d
    ```
    Then, run a Sonar analysis:
    ```
    ./mvnw -Pprod clean test sonar:sonar
    ```
7.  Using Docker to simplify development (optional): dockerize the application and all the services that it depends on.
    To achieve this, build a docker image of your app by running:
    ```
        ./mvnw package -Pprod verify jib:dockerBuild
    ```
    Then run:
    ```
        docker-compose -f src/main/docker/app.yml up -d
    ```

## Development process and code walk thru

This application was generated using a rapid prototyping tool called JHipster, you can find documentation and help at https://www.jhipster.tech/ .

1. input file city.txt is at src/main/resources.
2. Rest Controller is com.jay.app.web.rest.ConnectedResource
3. Application configuration added by mr is at com.jay.app.config.ConnectedCitiesAppConfig
4. com.jay.app.config.SecurityConfiguration class's configure(HttpSecurity http) was modified to allow access to
   api/connected and
   api/connected/listconnectedcities endpoints.
