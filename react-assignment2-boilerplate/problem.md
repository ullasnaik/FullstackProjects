# Assignmet 2

## Objective:
The Objective of this application is to understand Forms, Authentication Security and Routing using React

### The estimated effort to complete this assignment is 3-4 hours

## Things to do
- Fork the boilerplate
- Clone the repo in your local directory
- Start coding in your local copy
- Push the code in git
- Submit the solution in Hobbesbes

## Boilerplate
React-level-2-assignment

## Prerequisites
- Fork this boilerplate repository
- Clone the boilerplate repository and cd into it
- Install dependencies npm install
- Run the backend npm run serve which shall run on port:3001
- Run the frontend npm start which shall run on port:3000

## Know your server
On running npm run serve, following apis would be available for your use -

To authenticate user - POST - http://localhost:3001/auth/v1 - expecting data - { username, password }

To check if user is authenticated - POST - http://localhost:3001/auth/v1/isAuthenticated - expecting header - { ‘Authorization’, Bearer ${token} }

To get news - GET - http://localhost:3001/api/v1/news - expecting header - { ‘Authorization’, Bearer ${token} }

To add a news - POST - http://localhost:3000/api/v1/news - expecting header - { ‘Authorization’, Bearer ${token} } and data - { news }


## The NEWS API to be used as data source
- To get category wise news use the following end point. [Category News endpoint]
(https://newsapi.org/v2/top-headlines?category=<<news_category>>&apikey=<<api_key>>&page=1)
- To get trending news use the following endpoint. [Top Headlines endpoint]
(https://newsapi.org/v2/top-headlines?country=in&apikey=<<api_key>>&page=1)
- To search for any news based on serach text . [News search endpoint]
(https://newsapi.org/v2/everything?q=<<search_text>>&apiKey=<<api_key>>&language=en&page=1)
## To register for an API key, follow these steps:
- You need to signup to [NEWSAPI] (https://newsapi.org/register).

- After registration, API key is generated for you.

## Assignment:

- Keep should use Bootstrap Design for it’s UI
- User shall be shown a login form
- After authentication, user is able to see all the news from NEWS api on the dashboard as Cards
- User is be able to create and persist news on server.
- User should be able to see the readnow button on the nav bar.
- User Should be able to read the News which is persisted in the Database


## Designe
Set of new components needs to be added

### Login
    1. Use to perform the login for the user
    2. Use Components/login folder to create Login component

### Register
    1. Use to perform register for the user
    2. Use Components/register folder to create Register component.
    3. Do not work on the register backend this will be completed with your backend

### ReadNow
    1. Use to display all the stored news so that we can read them
    2. Use Components/readNow folder to create ReadNow component.

### DisplayCard
    1. DisplayCard component should capture all the news from the server on the click of readNow.
    2. Readnow component should use display card component to display the news.
    3. User Components/displayCard folder to create DisplayCard.

### Services (Folder)
- this folder should be places inside src.
- used to have all the services.
- All the api or db communication should happen through services.


## Instructions:
1. index.js should call app.js
2. app.js should have roughts for login, dashboard, register and readnow.
3. Header should have dashboard and readnow buttons.
4. dashboard page and readnow page should not be opened until the user is logined.
5. After login the token should be stored in the browser localstorage.
6. After login the name on the header should be changed into the login user name.
7. logout button should delete the values from localstorage.
8. Create the UI only for the register and add that with a link on login page.

# Submitting your solution for preliminary automated review
- Open Hobbes and login into the platform
- Under Assignment repository select React-level-2-assignment, and branch master
- Under Your solution repository select your own repository and branch
- Press Submit
- Press click here for the feedback
- Evaluation will take around 5 mins to complete after which you need to refresh your browser and get the updated status
- Watch out for your total score and detailed status on each test and eslint errors in the coloured blocks on the screen
- Fix failing test cases as well as eslint errors and re-submit your solution (you may skip any eslint errors reported in the provided spec files)
