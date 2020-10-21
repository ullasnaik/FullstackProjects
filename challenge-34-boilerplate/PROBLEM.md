## Problem Statement - Searching For A Product

In this challenge, you are going to revisit the solution created for challenge-32 and will implement searching for a product based on `pid`. The search algorithm should be fast so that the wait time can be reduced as much as possible so that the user looking for the product can find the product very fast. Before choosing the searching algorithm, ensure you analyze the data.

Measure the time taken to perform the searching operations on the given dataset using `System.currentTimeMillis()`. It was one of the client requirement to ensure that the sorting algorithm will have to take minimal time. 

> Please note that this data set is publicly available and is downloaded from `https://www.kaggle.com/PromptCloudHQ/flipkart-products`.

The file contains the following information:
- pid - contains the unique product ID
- product_name - contains the product name as it is displayed on the site
- brand - contains the brand of the product being sold.
- product_url - contains the URL for the product.
- retail_price - contains the retail price excluding any discount
- discounted_price - contains the discounted price excluding any discount
- product_rating - contains the product_ratings. product_rating can be ranging from 1 to 5. However, there are several products which does not have any rating. In those cases, the ratings should be considered as 0.

Following are the key objectives for this challenge:

- Write a method which will search for product based on it's `pid` and return the product details, which can be displayed by the user in an appropriate format based on the User Interface of the application.

## Test Cases

- ACCDVFK6KGJUGSRH - should return a product
- SHTEBTB9JZZZKYBD - should return a product
- SHTEBTB9JZZZKYCD - should print that no product is available with the specific pid and return null 

> You need handle all exceptional situation that might occur during reading the file,
> parsing the values etc.
