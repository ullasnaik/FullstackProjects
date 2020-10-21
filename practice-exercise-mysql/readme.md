## Seed code - My SQL - Practice Exercise

### Exercise Instructions (Must be followed mandatorily)

- *Read the given set of questions and solve them by writing queries using MySQL*
- *Queries should be wriiten in MySQL syntax*

### Problem Statement

Sales management app which is used to store Sales_Rep, Customer,and Invoice. Create the necessary tables, relationships and add sample data into each table.

### Expected Solution

*Note: Do not add `create database/schema` query in the solution*

DDL

Create the tables for Sales_Rep, Consumer and Invoice.

Sales_Rep table fields: Rep_ID Integer, Name varchar, City varchar, commision double, Rep_ID primary key.

Consumer table fields: Consumer_ID Integer, Consumer_Name varchar, City varchar, Grade varchar, Rep_ID Integer  Consumer_ID Primary Key, Rep_ID Foreign key

Invoice table fields : Invoice_ID Integer, Invoice_amount double , Invoice_Date date , Consumer_ID Integer, Rep_ID Integer  Invoice_ID primary Key, Consumer_ID and  Rep_ID Foreign Key

DML

Insert the rows into the created tables (Sales_Rep, Consumer, Invoice) as given below.  

Sales_Rep  

|  Rep_ID  |  Name         |  City       |  commision  |  
|---|---|---|---|  
| 1001     |  Anthony G    |  New Delhi  | 0.25        |  
| 1002     |  Rejina R     |  Bangalore  | 0.15        |  
| 1003     |  Santhosh     |  Mumbai     | 0.12        |  
| 1005     |  Jaya Prasad  |  Chennai    | 0.11        |  
| 1006     |  Diptish      |  Kolkatta   | 0.12        |  
| 1007     |  Abbas        |  Hyderabad  | 0.1         |  

Consumer  

|  Consumer_ID  |  Consumer_Name  |  City       |  Grade  |  Rep_ID  |  
|---|---|---|---|----|  
| 3001          |  Mary           |  Chennai    |   NULL  | 1005     |  
| 3002          |  Nirav Parmar   |  New Delhi  | 100     | 1001     |  
| 3003          |  Ram Sangeeth   |  Hyderabad  | 200     | 1007     |  
| 3004          |  Somsubhra      |  Kolkatta   | 300     | 1006     |  
| 3005          |  James          |  Bangalore  | 200     | 1002     |  
| 3007          |  Harish Manana  |  New Delhi  | 200     | 1001     |  
| 3008          |  Rajesh Kumar   |  Bangalore  | 300     | 1002     |  
| 3009          |  Sharon George  |  Mumbai     | 100     | 1003     |  

Invoice  

|  Invoice_ID  |  Invoice_amount  |  Invoice_Date  |  Consumer_ID  |  Rep_ID  |  
|---|---|---|---|---|  
| 10001        | 1500.5           | 2017-10-05     | 3005          | 1002     |  
| 10002        | 6560.2           | 2017-10-05     | 3002          | 1001     |  
| 10003        | 2480.4           | 2017-10-10     | 3009          | 1003     |  
| 10004        | 1100.5           | 2017-08-17     | 3009          | 1003     |  
| 10005        | 2400.6           | 2017-07-27     | 3007          | 1001     |  
| 10007        | 9480.5           | 2017-09-10     | 3005          | 1002     |  
| 10008        | 5760             | 2017-09-10     | 3002          | 1001     |  
| 10009        | 2700.6           | 2017-09-10     | 3001          | 1005     |  
| 10010        | 1983.43          | 2017-10-10     | 3004          | 1006     |  
| 10011        | 7500.29          | 2017-08-17     | 3003          | 1007     |  
| 10012        | 2500.45          | 2017-06-27     | 3008          | 1002     |  
| 10013        | 3045.6           | 2017-04-25     | 3002          | 1001     |  


SELECTION   

Write a SQL Query to retrieve the details of the Consumer like 
Consumer_ID, Consumer_Name, City , Grade , Rep_ID who are from
Bangalore and Kolkatta.

Write a SQL Query to retrieve the details of the Invoice 
like Invoice_ID, Invoice_Date, Consumer_ID, Rep_ID, Invoice_Amount
whose Invoice_Amount is more than 5000.

Write a SQL Query to retrieve the details of the Sales Rep like 
Rep_ID, Name, City ,Commision who are from city that ends with 'i'.

PROJECTION

Write a SQL statement to display specific columns like 
name, city and commision for all the salesmen. 

Write a query to display all the details of the Invoice 
like Invoice_Date, Rep_ID, Invoice_ID and Invoice_Amount.

Group By , Order By Clauses

Write a SQL Statement to fetch the Details Consumer like 
Consumer_ID, Consumer_Name , City , Grade 
in alphabetical order of Name.
 

### Problem Statement [JDBC API]

Write a Java code to retrive Sales_Rep details using JDBC API.
[Hint : DriverManager, Connection, Statement, ResultSet]


Write a Java code to store Sales_Rep details using JDBC API.
[Hint : DriverManager, Connection, PreparedStatement, ResultSet]
