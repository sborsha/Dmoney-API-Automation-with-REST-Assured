# Demoney API Automation with REST Assured
This is simple project of Dmoney API Automation test using with REST Assured. Here I have used TestNG as a test framework and generate random users create with faker library.

## Test Scenarios
1. Do Login by admin
2. Create 2 new customers and a agent
3. Give money from System account to the newly created agent
4. Deposit money to a customer from the agent account
5. Withdraw money by the customer to the agent
6. Send money money tk to another customer
7. Payment money tk to a merchant by the recipient customer
8. Check balance of the recipient customer

## Required Tools & Tech
  * Installed Java Development Kit (JDK)
  * IntelliJ Idea or any community (JAVA IDE)
  * Selenium with TestNG
  * Allure
  * Gradle

## How to Run this Project
  * Clone this project repo

        https://github.com/sborsha/Dmoney-API-Automation-with-REST-Assured.git
  * Open this file with IntelliJ Idea or any community (JAVA IDE)
  * Run the command in command line

        gradle clean test
  * To generate report with the command

        allure generate allure-results --clean -output
        allure serve allure-results

## Allure Report
![Allure-RestAssured](https://github.com/sborsha/Dmoney-API-Automation-with-REST-Assured/assets/97577812/a0cb9191-3d7d-4021-8b5e-541d816e5933)
![AllureBehavior-RestAssured](https://github.com/sborsha/Dmoney-API-Automation-with-REST-Assured/assets/97577812/b42d7b20-ccc7-45d1-a22f-3819d6b5b64f)

