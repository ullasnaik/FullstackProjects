# Assignmet 3

## Objective:
The Objective of this application is to Add few more features on the news application and work on end to end test cases in cypress

### The estimated effort to complete this assignment is 3-4 hours

## Things to do
- Fork the boilerplate
- Clone the repo in your local directory
- Start coding in your local copy
- Push the code in git
- Submit the solution in Hobbesbes

## Boilerplate
React-level-3-assignment

## Prerequisites
- Fork this boilerplate repository
- Clone the boilerplate repository and cd into it
- Install dependencies npm install
- Run the backend npm run serve which shall run on port:3001
- Run the frontend npm start which shall run on port:3000
- Run Cypress test cases "npm run cypress"

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
- On the header user should be able to see a filter button
- On clicking on filter button user should be able to see a model with can provide different filter options like
    1. endpoints
    2. country
    3. category
    4. sources
    5. q
    6. pageSize
    7. page
- Add End to End cypress test to test the UI of the application 

## Endpoints:
    News API 3 ensendpoints:
-  Top headlines /v2/top-headlines - returns breaking news headlines for a country and category, or currently running on a single or multiple sources. This is perfect for use with news tickers or anywhere you want to display live up-to-date news headlines and images.

- Everything /v2/everything - we index every recent news and blog article published by over 30,000 different sources large and small, and you can search through them with this endpoint. This endpoint is better suited for news analysis and article discovery, but can be used to retrieve articles for display too.

- Sources /v2/sources - returns information (including name, description, and category) about the most notable sources we index. This list could be piped directly through to your users when showing them some of the options available.

## country
The 2-letter ISO 3166-1 code of the country you want to get headlines for. Possible options: ae ar at au be bg br ca ch cn co cu cz de eg fr gb gr hk hu id ie il in it jp kr lt lv ma mx my ng nl no nz ph pl pt ro rs ru sa se sg si sk th tr tw ua us ve za . Note: you can't mix this param with the sources param.

## category
The category you want to get headlines for. Possible options: business entertainment general health science sports technology . Note: you can't mix this param with the sources param.

## sources
A comma-seperated string of identifiers for the news sources or blogs you want headlines from. Use the /sources endpoint to locate these programmatically or look at the sources index. Note: you can't mix this param with the country or category params.

## q
Keywords or a phrase to search for.

## pageSize
The number of results to return per page (request). 20 is the default, 100 is the maximum.

## page
Use this to page through the results if the total results found is greater than the page size.

## Designe
Set of new components needs to be added

### Filter
- this component is responsible to provide a user an option to filter what a user wants to read. 

### Services (Folder)
- Add a service named as filter service to provide the functionality.
### news.spec.js
- add news.spec.js to write the test cases in the news file.

## Instructions:
1. copy paste first assignment solution to pass the test cases.
2. Add the new code into the old.
3. check for the full ui and responsivness of the application.

# Submitting your solution for Manual Review

- Schedual a demo with your mentor to present the application.
- Submit the Assignment to your mentor for manual review.