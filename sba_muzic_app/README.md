# Muzix - A Capsule Case Study

## Problem Statement

Build a system to search for music, show list of music titles, bookmark music, create playlists and show recommended music to a user.

## Requirements:
1. The application needs to fetch music details from https://www.last.fm/api or https://developer.napster.com/
2. A frontend where the user can search, view, play music, bookmark it and should be able to create multiple playlist out of it.

  - On launching the application the user should get the login page. The login page should have a link for registration using which the user should be able to register. On successful registration the user should be taken to the login page. Upon login, the user should be taken to the home page.
  - Proper navigation links for all the pages should be available within pages.
  - Error handling should be implemented across pages. Appropriate messages should be    displayed for the same. Success messages should be displayed for the User Registration.
  - Logout feature should be implemented.

3. A recommendation system should be able to recommend with similar music to the user based on the music played and playlist created. Any music added to the Favorites should be consumed by the Recommendation service using the Rabbit-MQ messaging service.

4. An option to view recommended music should be available on frontend. 

## Microservices:
1. MuzixUI -
    -  User should be able to
        - search music
        - bookmark music
        - create playlists
        - should be able to see bookmarked music and playlists created by him
        - should be able to see recommended music
    -  UI should be responsive which can run smoothly on various devices.
    -  UI is appealing and user friendly.

2. AccountManager - Should be able to manage user accounts
3. MuzixManager - should be able to store all his
    - bookmarks
    - playlists
    - searches
4. MuzixRecommenderSystem - Based on the music bookmarked and playlisted, it should be able to   recommend new music to the user

## Modules Required:
  - Spring Boot
  - MySQL, MongoDB
  - Zuul API Gateway
  - Eureka Server
  - Message Broker (Kafka)
  - React
  - CI (Gitlab Runner)/Zenkins
  - Docker, Docker Compose


## Flow of Modules

### Building Frontend:
  1. Building Responsive Views:
      - Build a View to show all music:
        - Music - Populating from external api
        - Recommended Music - Populating from MuzixRecommenderSystem
        - Build a view to show created playlist
        - A view to authenticate users
  2. Using Services to populate these data in views
  3. Stitching these views using Routes and Guards
  4. Unit Tests should be created for the Components and Services
  5. E2E scripts using cypress should be created for the functional flows
  6. Implement CI - continuous Integration ( use .gitlab-ci.yml)/Zenkins
  7. Dockerize the frontend (create dockerfile, docker-compose.yml and get it executed through docker compose)


### Note: FrontEnd and all the backend services should be dockerized and run through docker-compose

### Building the Account Manager
  1. Creating a server in Spring Boot to facilitate registration and login with MySQL as backend. Upon login, JWT token has to be generated. It has to be used in the Filters set in other services.
  2. Writing Swagger Documentation
  3. Unit Testing of the entire code which involves the positive and negative scenarios
  4. Implement continuous Integration CI ( use .gitlab-ci.yml)/Zenkins
  5. Dockerize the AccountManager service (create dockerfile, docker-compose.yml and get it executed through docker compose)

### Create an API Gateway (Zuul) which can serve UI and API Request from same host. 

### Apply JWT Authentication in the API Gateway for all the incoming requests


### Building the Muzix Manager
  1. Building a server in Spring Boot to facilitate CRUD operation over music, playlist and bookmarked resources stored in MongoDB.
  2. Writing Swagger Documentation
  3. Build a Producer for Kafka which:
      - Produces events like what user bookmarked
      - What music he added in playlists
  4. Write Unit Test Cases and get it executed. 
  5. Implement CI - continuous Integration ( use .gitlab-ci.yml) /Zenkins
  6. Dockerize the service(create dockerfile and update the docker-compose.yml)


### Building the MuzixRecommenderSystem
  1. Build a Consumer for Kafka:
      - On a new event generated Update the recommendations in the system
  2. Build an API to get Recommendations
  3. Writing Swagger Documentation
  4. Write Unit Test Cases and get it executed. 
  5. Implement CI - continuous Integration ( use .gitlab-ci.yml) /Zenkins
  6. Dockerize the service(create dockerfile and update the docker-compose.yml)
  7. Update the API Gateway

### Demonstrate the entire application
    1. Make sure all the functionalities are implemented completely
    2. Make sure both the UI (Component and Services) and server side (For all layers) codes are unit tested. 
    3. All the Services are up and running using docker (Dockercompose should be used for running them)
    4. Eureka server should be running and all the required services are registered and started
    5. Kafka service should be running ( check whether exchanges are created)
    6. E2E tests should have been created and can be executed successfully
    7. Application is completely responsive in nature