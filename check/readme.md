<div align="center">
 ![StackRoute Logo](screenshots/sr-logo.png)
</div>

## Seed code - Boilerplate for step 3 - Newz Assignment

### Assignment Step Description

In this Case study: Newz Step 3, we will create a RESTful application with SLF4j Logger implemented using AOP in a Spring Boot application.

Representational State Transfer (REST) is an architectural style that specifies constraints. 
In the REST architectural style, data and functionality are considered resources and are accessed using Uniform Resource Identifiers (URIs), typically links on the Web.

Resources are manipulated using a fixed set of four create, read, update, delete operations: PUT, GET, POST, and DELETE. 
 - POST creates a new resource, which can be then deleted by using DELETE. 
 - GET retrieves the current state of a resource in some representation. 
 - PUT transfers a new state onto a resource. 

### Problem Statement

In this case study, we will develop a RESTful application using Spring boot with which we will operations such as register a user, create a News item and delete an news item, set a reminder to the news. Also, we will check the performance of the operations with the help of Postman API.

### Solution Step

        Step 1: Configure Postman in your Google Chrome
        Step 2: Use URI's mentioned in the controller to check all the expected operations using Postman.

### Following are the broad tasks:

 - Create a new user, update the user, retrieve a single user, delete the user and get the list of all users.
 - Create a News, update a news, delete a news, get all news.
 - Create a Reminder, update a Reminder,  delete a Reminder, get all Reminders.
 - Add logger for all the controller methods.

 

### Steps to be followed:

    Step 1: Clone the boilerplate in a specific folder on your local machine and import the same in your eclipse STS.
    Step 2: Add relevant dependencies in pom.xml file. 
        Note: Read the comments mentioned in pom.xml file for identifying the relevant dependencies. 
  
    Step 5: Define the data model classes (UserProfile, Reminder, News)
    Step 6: Test each and every model with appropriate test cases.
    Step 7: Create the Repository interfaces which should implement the JpaRepository interface.
    Step 10: See the methods mentioned in the service interface.
    Step 11: Implement all the methods of service interface in ServiceImpl.
    Step 12: Test each and every serviceImpl with appropriate test cases.
    Step 13: Write controllers to work with RESTful web services. 
    Step 14: Test each and every controller with appropriate test cases.
    Step 15: Go through logback.xml in resources. 
    Step 16: Write loggers for each of the methods of controller.
    Step 17: Test LoggingAspect with LoggerTest cases.
    Step 18: Check all the functionalities using URI's mentioned in the controllers with the help of Postman for final output.
    

### Project structure

The folders and files you see in this repositories is how it is expected to be in projects, which are submitted for automated evaluation by Hobbes

    Project
    ├─src/main/java
            |
            ├── com.stackroute.newz 
            |        └── NewzApplication.java
            ├── com.stackroute.newz.aspect 
            |        └── LoggingAspect.java  		   // This class will contain logger for all the controller methods.
            ├── com.stackroute.newz.controller
            |        └── NewsController.java           // This class is responsible for processing all requests related to News and builds an appropriate model and passes it to the view for rendering.
            |        └──UserProfileController.java               // This class is responsible for processing all requests related to UserProfile and builds an appropriate model and passes it to the view for rendering.
            |        └── ReminderController.java           // This class is responsible for processing all requests related to Reminder and builds an appropriate model and passes it to the view for rendering.
  
            ├── com.stackroute.newz.repository
            |        └── NewsRepository.java                  // This interface contains all the behaviors of the News Model
            |        └── UserProfileRepository.java                      // This interface contains all the behaviors of UserProfile Model    
            |        └── ReminderRepository.java                  // This interface contains all the behaviors of Reminder Model
            

            ├── com.stackroute.newz.util.exception
            |        └──NewsNotExistsException.java     // This class extends Exception and used for a custom exception. 
            |        └──ReminderNotExistsException.java         // This class extends Exception and used for a custom exception. 
            |        └──UserProfileNotExistsException.java     // This class extends Exception and used for a custom exception. 
            |        └──UserProfileAlreadyExistsException.java     // This class extends Exception and used for a custom exception. 
            |        └──NewsAlreadyExistsException.java         // This class extends Exception and used for a custom exception. 

            ├── com.stackroute.newz.model
            |        └── News.java                     // This class will be acting as the data model for the News Table in the database.
            |        └── Reminder.java                     // This class will be acting as the data model for the Reminder Table in the database.
            |        └── UserProfile.java                         // This class will be acting as the data model for the UserProfile Table in the database.

            ├── com.stackroute.newz.service
            |        └──NewsService             // This interface contains all the behaviors of News Model
            |        └──NewsServiceImpl         // This class implements the NewsService interface. This class has to be annotated with @Service annotation.
            |        └──ReminderService            // This interface contains all the behaviors of Reminder Model
            |        └──ReminderServiceImpl        // This class implements the ReminderService interface. This class has to be annotated with @Service annotation.
            |        └──UserProfileService                // This interface contains all the behaviors of UserProfile Model
            |        └──UserProfileServiceImpl            // This class implements the UserProfileService interface. This class has to be annotated with @Service annotation.
    ├─src/main/resources
            |        └── logback.xml
            |        └── application.properties    
    ├─src/test/java                            // All the test case classes are made available here
            ├── com.stackroute.newz.test.controller                  
            |        └── NewsControllerTest.java
            |        └── UserProfileControllerTest.java
            |        └── ReminderControllerTest.java
                
            ├── com.stackroute.newz.test.service
            |        └── NewsServiceTest
            |        └── UserProfileServiceTest
            |        └── ReminderServiceTest
            
            ├── com.stackroute.newz.test.log
            |        └── LoggerTest.java
            ├── com.stackroute.newz.test.model
            |        └── NewsTest.java
            |        └── ReminderTest.java
            |        └── UserProfileTest.java
            |        └── LocalDateTimeFactory.java
            
            ├── .classpath                                  // This file is generated automatically while creating the project in eclipse
            ├── .hobbes                                     // Hobbes specific config options, such as type of evaluation schema, type of tech stack etc., Have saved a default values for convenience
            ├── .project                                    // This is automatically generated by eclipse, if this file is removed your eclipse will not recognize this as your eclipse project. 
            ├── pom.xml                                     // This is a default file generated by maven, if this file is removed your project will not get recognized in hobbes.
            └── readme.md                                  // This files describes the problem of the assignment/project, you can provide as much as information and clarification you want about the project in this file

> PS: All lint rule files are by default copied during the evaluation process, however, if need to be customized, you should copy from this repo and modify in your project repo


#### To use this as a boilerplate for your new project, you can follow these steps

1. Clone the base boilerplate in the folder **assignment-solution-step3** of your local machine
     
    `git clone <GIT REPO LINK>`

2. Navigate to assignment-solution-step3 folder

    `cd assignment-solution-step3`

3. Remove its remote or original reference

     `git remote rm origin`

4. Create a new repo in gitlab named `assignment-solution-step3` as private repo

5. Add your new repository reference as remote

     `git remote add origin <GIT REPO LINK>`

     **Note: {{yourUserName}} should be replaced by your userName from gitlab**

5. Check the status of your repo 
     
     `git status`

6. Use the following command to update the index using the current content found in the working tree, to prepare the content staged for the next commit.

     `git add .`
 
7. Commit and Push the project to git

     `git commit -a -m "Initial commit | or place your comments according to your need"`

     `git push -u origin master`

8. Check on the git repo online, if the files have been pushed

### Important instructions for Participants
> - We expect you to write the assignment on your own by following through the guidelines, learning plan, and the practice exercises
> - The code must not be plagirized, the mentors will randomly pick the submissions and may ask you to explain the solution
> - The code must be properly indented, code structure maintained as per the boilerplate and properly commented
> - Follow through the problem statement shared with you

### MENTORS TO BEGIN REVIEW YOUR WORK ONLY AFTER ->
> - You add the respective Mentor as a Reporter/Master into your Assignment Repository
> - You have checked your Assignment on the Automated Evaluation Tool - Hobbes (Check for necessary steps in your Boilerplate - README.md file. ) and got the required score - Check with your mentor about the Score you must achieve before it is accepted for Manual Submission.
> - Intimate your Mentor on Slack and/or Send an Email to learner.support@stackroute.in - with your Git URL - Once you done working and is ready for final submission.


### Further Instructions on Release

*** Release 0.1.0 ***

- Right click on the Assignment select Run As -> Java Application to run your Assignment.
- Right click on the Assignment select Run As -> JUnit Test to run your Assignment.
