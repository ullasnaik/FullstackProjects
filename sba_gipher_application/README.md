# Gipher - A Capsule Case Study

## Problem Statement

Build a system to manage and recommend GIFs to a user. Refer https://giphy.com/

## Requirements:

1. The application needs to fetch gifs from https://developers.giphy.com/docs/

2. A frontend where the user can register/login to the application,search, view and bookmark gifs.
  - On launching the application the user should get the login page. The login page should have a link for registration using which the user should be able to register. On successful registration the user should be taken to the login page. Upon login, the user should be taken to the home page.
  - Proper navigation links for all the pages should be available within pages.
  - Error handling should be implemented across pages. Appropriate messages should be    displayed for the same. Success messages should be displayed for the User Registration.
  - Logout feature should be implemented.

3. A user can add a gif to bookmark and should be able to view bookmark list.

4. A recommendation service should be able to store all the unique bookmarked gifs from all the users and maintain counter for number of users added a particular gifs into bookmark list. 

5. An option to view recommended gifs should be available on frontend. 

## Modules:
1. AccountManager - Should be able to manage user accounts
2. GipherUI -
  - User should be able to
    - search GIFs
    - bookmark GIFs
    - should be able to see bookmarked GIFs
  - Application should be a responsive which can smoothly run on mobile devices.
3. GipherManager - Application should be able to store all his
  - bookmarks
  - searches
4. GipherRecommenderSystem - should be able to store all the unique bookmarked gifs from all the users and maintain counter for number of users added a particular gifs into bookmark list.

## Modules Required:
- Spring Boot
- MySQL, MongoDB
- Zuul API Gateway
- Eureka Server
- Message Broker (Kafka)
- React
- CI (Gitlab Runner/Zenkins)
- Docker, Docker Compose

## Flow of Modules

### Building Frontend:
  1. Building Responsive Views:
    - Build a View to show all GIF’s
      - GIF’s - Populating from external api
      - Recommended GIF’s - Populating from GipherRecommenderSystem
      - Build a view to show bookmarked gifs
      - A view to authenticate users
  2. Using Services to populate these data in views
  3. Stitching these views using Routes and Guards
  4. Making the UI Responsive
  5. Unit Tests should be created for the Components and Services
  6. E2E scripts using protractor should be created for the functional flows
  7. Implement CI - continuous Integration ( use .gitlab-ci.yml)
  8. Dockerize the frontend (create dockerfile, docker-compose.yml and get it executed through docker compose)

### Note: FrontEnd and all the backend services should be dockerized and run through docker-compose

### Building the AccountManager
  1. Creating a server in Spring Boot to facilitate registration and login with MySQL as backend. Upon login, JWT token has to be generated. It has to be used in the Filters set in other services.
  2. Writing Swagger Documentation
  3. Unit Testing of the entire code which involves the positive and negative scenarios
  4. Implement continuous Integration CI ( use .gitlab-ci.yml)
  5. Dockerize the AccountManager service (create dockerfile, docker-compose.yml and get it executed through docker compose)

### Create an API Gateway (Zuul) which can serve UI and API Request from same host. 

### Apply JWT Authentication in the API Gateway for all the incoming requests

### Building the GipherManager
  1. Building a server in Spring Boot to facilitate CRUD operation over GIF’s and bookmarked resources stored in MongoDB
  2. Writing Swagger Documentation
  3. Build a Producer for Kafka which
    1. Produces events like what user bookmarked
  4. Write Unit Test Cases and get it executed.
  5. Implement CI - continuous Integration ( use .gitlab-ci.yml)/Zenkins
  6. Dockerize the service(create dockerfile and update the docker-compose.yml)

### Building a GipherRecommenderSystem
  1. Building a Consumer for Kafka
      - On a new event generated Update the recommendations in the system. Store the recommendation list in MongoDB.
      - Maintain list of unique recommended gifs based on what user added into   of bookmark and keep counter for number of users added a particular gif into bookmark list.
  2. Build an API to get recommendations
  3. Writing Swagger documentation
  4. Write Unit Test Cases and get it executed.
  5. Implement CI - continuous Integration ( use .gitlab-ci.yml)/Zenkins
  6. Dockerize the service(create dockerfile and update the docker-compose.yml)
  7. Update the API Gateway

### Create Eureka server and make other services as client

### Demonstrate the entire application
    1. Make sure all the functionalities are implemented
    2. Make sure both the UI (Component and Services) and server side (For all layers) codes are unit tested. 
    3. All the Services are up and running using docker (Dockercompose should be used for running them)
    4. Eureka server should be running and all the required services are registered and started
    5. Kafka service should be running ( check whether exchanges are created)
    6. E2E tests should have been created and can be executed successfully
    7. Application is completely responsive in nature