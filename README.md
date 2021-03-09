# Sample Project - Backend REST API

## Purpose

This project delivers backend REST APIs to support a web application that allows a user to view
accounts and subsequently view transactions on any of the accounts they hold.

Required functionality:
 - View account list
 - Viwe account transactions
 
## System Components

This project has been built using Java SE 8 and Spring Boot components managed via Maven:
 - spring-boot-starter-web
 - spring-boot-starter-data-jpa
 - spring-boot-starter-data-rest
 - h2
 - spring-boot-starter-test
 - spring-boot-starter-webflux  

## Project Setup

The Springboot project provides a microservice hosted on Tomcat and leverages Spring Data
JPA repositories. Thus a H2 in-memory database is been included, and sample data loaded into this 
database on application startup. Data is hardcoded but could be file imports. 

Spring Data automatically exposes RESTful APIs as per the methods in the Interface: 
org.springframework.data.repository.CrudRepository;
 
Thus running the application will start the server and expose the APIs.

APIs are delivered in a HATEOAS form. Thus API responses contain href links to other possible
API calls to facilitate navigation around the application.   

## Project Structure

The project has been structured as follows:

 - accounts
   - src
     - main
       - java
         - com.example.accounts
           - domain
             - c Account
             - e AcctType
             - e Currency
             - c Transaction
             - e TxnType
           - repo
             - AccountRepository
             - TransactionsRepository
           - service
             - c AccountsApplication
     - test
       - java
         - com.example.accounts
           - c AccountsApplicationTests

## Application Execution

To run and test the application, either:

1. Run application from IDE 
   - Load project into an IDE
   - Setup an Application run configuration with main class: com.example.accounts.AccountsApplication.
   - Test application using a REST client - ARC, Postman, etc. 

2. Run JUnit tests from IDE 
   - Load project into an IDE
   - Setup a JUnit run configuration with main class: com.example.accounts.AccountsApplicationTests.
   - Tests include:
     - testContextLoads()
     - testGetAccountById()
     - testGetAccountByAcctNoA()
     - testDeleteAccountById()
     - testGetTransactions() 

3. Run application from command line 
   - Project includes a JAR file: \accounts\target\accounts-0.0.1-SNAPSHOT.jar
   - Open a terminal window
   - From the accounts directory, run: "java -jar target/accounts-0.0.1-SNAPSHOT.jar"
   - Test application using a REST client - ARC, Postman, etc. 
 
## APIs Exposed

The following APIs have been exposed:

 - http://localhost:8080/accounts/
 - http://localhost:8080/accounts/{acctId}
 - http://localhost:8080/accounts/search/findByAcctNo?acctNo={acctNo}
 - http://localhost:8080/transactions/
 - http://localhost:8080/transactions/{transactionId}

Create, Update and Delete APIs that are automatically exposed have been overrriden
to prevent them from being exposed.
