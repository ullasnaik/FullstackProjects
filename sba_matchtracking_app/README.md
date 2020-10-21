# CMatches - A Case Study

## Problem Statement

Cricket is one of international sport and it is widely popular in India.
 
This case study is about showing current and old cricket matches played around the world. Also the details about each match including score and other statistics has to be displayed.

Build a system to find current cricket matches, bookmark favourite matches and recommend most liked/favourite matches to user.

## Requirements

1. The application needs to fetch cricket matches from the following API.
https://www.cricapi.com/

Refer the following URLs to explore more on the cricket match APIs.
https://www.cricapi.com/how-to-use.aspx
https://www.cricapi.com/how-to-use/next-matches-api.aspx
https://www.cricapi.com/how-to-use/match-api.aspx
https://www.cricapi.com/how-to-use/scores-api.aspx

2. A frontend where the user can register/login to the application, find current or old cricket matches, add interested matches to favourite list and view recommended matches.
  - On launching the application the user should get the login page. The login page should have a link for registration using which the user should be able to register. On successful registration the user should be taken to the login page. Upon login, the user should be taken to the home page.
  - Proper navigation links for all the pages should be available within pages.
  - Error handling should be implemented across pages. Appropriate messages should be    displayed for the same. Success messages should be displayed for the User Registration.
  - Logout feature should be implemented.

3. The upcoming cricket schedule can be displayed on the home page as a calendar as a quick view to the user. This can be viewed after successful login into the application.

4. The complete match statistics can be displayed for a selected cricket match.

5. User can add a match to favourite list and should be able to view favourite matches.

6. A recommendation engine should be able to store all the unique favourite matches from all the users and maintain counter for number of users added a particular match into favourite list. 

7. An option to view recommended matches should be available on frontend. 

## Microservices/Modules
- UI (User interface) -  should be able to
    - View cricket calendar
    - View current matches
    - Add a match to favourite list
    - view favourite matches
    - view recommended matches
- UI should be responsive which can run smoothly on various devices 
- UserService - should be able to manage user accounts.
- FavouriteService - should be able to store all the favourite matches for a user
- MatchRecommendationService - should be able to store all the unique favourite matches from all the users and maintain counter for number of users added a particular match into favourite list.

## Tech Stack

- Spring Boot
- MySQL, MongoDB
- Zuul API Gateway
- Eureka Server
- Message Broker (RabbitMQ)
- React
- CI (Gitlab Runner)
- Docker, Docker Compose

## Flow of Modules

### Building frontend:
  1. Building responsive views:
    - Register/Login
    - Cricket Matches - populating from external API
    - Build a view to show favourite matches
    - Build a view to show recommended matches
  2. Using Services to populate these data in views
  3. Stitching these views using Routes and Guards
  4. Making the UI Responsive
  5. Unit Tests should be created for the Components and Services
  6. E2E scripts using cypress should be created for the functional flows
  7. Implement CI - continuous Integration ( use .gitlab-ci.yml)
  8. Dockerize the frontend (create dockerfile, docker-compose.yml and get it executed through docker compose)


### Note: FrontEnd and all the backend services should be dockerized and run through docker-compose

### Building the UserService
  1. Creating a server in Spring Boot to facilitate user registration and login with MySQL as backend. Upon login, JWT token has to be generated. It has to be used in the Filters set in other services.
  2. Writing swagger documentation
  3. Unit Testing of the entire code which involves the positive and negative scenarios
  4. Implement continuous Integration CI ( use .gitlab-ci.yml)
  5. Dockerize the UserService (create dockerfile, docker-compose.yml and get it executed through docker compose)

### Create an API Gateway (Zuul) which can serve UI and API Request from same host. 

### Apply JWT Authentication in the API Gateway for all the incoming requests

### Building the FavouriteService
  1. Building a server in Spring Boot to facilitate CRUD operation over favourite matches stored in MySQL
  2. Writing Swagger Documentation
  3. Build a Producer for RabbitMQ which:
    - i. Produces events like what user added into favourite list
  4. Write Unit Test Cases and get it executed.
  5. Implement CI - continuous Integration ( use .gitlab-ci.yml)
  6. Dockerize the service(create dockerfile and update the docker-compose.yml)

### Building the MatchRecommendationService
  1. Building a Consumer for RabbitMQ
     - i. On a new event generated Update the recommendations in the system
     - ii. Maintain list of recommended matches based on what user added into favourite list and keep counter for number of users added a particular match into favourite list
  2. Build an API to get Recommendations
  3. Writing Swagger Documentation
  4. Write Unit Test Cases and get it executed.
  5. Implement CI - continuous Integration ( use .gitlab-ci.yml)
  6. Dockerize the service(create dockerfile and update the docker-compose.yml)
  7. Update the API Gateway

### Create Eureka server and make other services as client

### Demonstrate the entire application
    1. Make sure all the functionalities are implemented
    2. Make sure both the UI (Component and Services) and server side (For all layers) codes are unit tested. 
    3. All the Services are up and running using docker (Dockercompose should be used for running them)
    4. Eureka server should be running and all the required services are registered and started
    5. Rabbit-MQ service should be running ( check whether exchanges are created)
    6. E2E tests should have been created and can be executed successfully
    7. Application is completely responsive in nature