# Neal_William_DawnPatrol_CaseStudy

  ## Description

   DawnPatrol is a surf journal for the modern surfer. Surf forecasting has and always will be more of an art than a science and in todays fast paced busy world people don't have time to waste. They want to figure out when conditions are truly worth carving out time in their day to get down to the beach. DawnPatrol allows you to catologue your sessions, spots and equipment so that you can sift through the data and find what conditions create your favorite sessions.

  ## Table of Contents 

  - [Installation](#installation)
  - [Usage](#usage)
  - [Database](#database)
  - [License](#license)
  - [Technology](#technology)
  - [Testing](#testing)

  ## Installation
  
Download the entire project. 

If you get it as a zip file, you must unzip it and import the Neal_William_DawnPatrol_CaseStudy directory contained within the main directory (NealSMSZip) in Eclipse or your IDE of choice. 

If you clone it from github you must import the Neal_William_DawnPatrol_CaseStudy contained within the main directory of the same name into eclipse or your IDE of choice.

Once you have the project, update the application.properties file with the desired url and database name as well as the valid username and login for your database. You only need to change the database name if you want it to have a different name on your local host or server. You MUST change the username and password fields to your MySQL login. Those Lines look like:

`spring.datasource.username=MYSQL_URL`

`spring.datasource.username=YOUR_MYSQL_USERNAME`

`spring.datasource.password=YOUR_MYSQL_USERNAME`
 

## Usage

  The main method is contained in the DawnPatrolApplication class in the com.will.dawnpatrol package. Run as a Spring Boot project to start and the database and tables will be automatically created. Navigate to localhost:8080 in your browser, register a user and then login to start using the application. The application will look like: 

  ![Login Screenshot](https://github.com/Will-Neal/Neal_William_DawnPatrol_CaseStudy/blob/main/Neal_William_DawnPatrol_CaseStudy/screenshots/loginPage.png?raw=true)

  ![Session Screenshot](https://github.com/Will-Neal/Neal_William_DawnPatrol_CaseStudy/blob/main/Neal_William_DawnPatrol_CaseStudy/screenshots/sessionPage.png?raw=true)

  ## Database

  The Database Schemas is described by the following diagram:

  ![Database Schema](https://github.com/Will-Neal/Neal_William_DawnPatrol_CaseStudy/blob/main/Neal_William_DawnPatrol_CaseStudy/db/dawnpatroldbSchema.png?raw=true) 
  
  ## License

  ![License Badge](https://img.shields.io/badge/license-MIT-orange?style=plastic=appveyor?raw=true)
  <br>
  
  [Click here for more information regarding the above license](https://opensource.org/licenses/MIT)
    
  ---
    
  ## Technologies

  - Java
  - Maven 
  - MySQL
  - Spring Data JPA
  - Thymeleaf
  - HTML
  - CSS
  - JS
  - Spring Security
  - slf4J
  - Lombok
  - JUnit 4
  - JUnit 5

  ## Testing

  Extensive testing has been completed on this project. There are 22 Junit4 tests run on the Service classes and Repositories. There is also a JUnit 5 parameterized test ran on a Controller method. 