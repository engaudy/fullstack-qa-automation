# A comprehensive full-stack automation project designed to support both UI and API testing,
# aimed at enhancing software quality and reliability.
# May 17th 2025
# Audy Chavarría Arango

## UI Approach

## 🛠 Technologies Used

- Java 17
- Maven v 3.9.9
- Selenium WebDriver 4
- Serenity BDD
- Cucumber 7
- JUnit 4

## 📌 Prerequisites
- Java 17
- Maven installed and available in your PATH
- Google Chrome (or modify the WebDriver config for another browser)

## 📁 Project Structure

src
├── main
│ └── java
├── test
│ ├── java
│ │ └── com.demoblaze.ui
│ │ ├── runners
│ │ │ └── RunCucumberTest.java
│ │ ├── stepdefinitions
│ │ └── pages
│ └── resources
│ └── features

## 🚀 Running the Tests

To execute the test suite and generate the Serenity report, run the following command:

```bash
- mvn clean verify
```

## 🧪 Checking Report
- Please go to file://{your-project-path}/target/site/serenity/index.html

## API Approach
# 🧪 Serenity API Test Automation Project

This project is designed to test the [Swagger Petstore API](https://petstore.swagger.io/) using **Serenity BDD**, **Rest-Assured**, 
and **Cucumber**. It follows a clean and modular structure, making it easy to create, execute, and maintain REST API test scenarios.

## 📁 Project Structure
src/test/java/com/demoblaze/api/
│
├── models/ → classes for Pet, User, and Order
├── stepdefinitions/ → Step definitions for Cucumber scenarios
├── utils/ → Utility methods for API calls
└── runners/ → Test runner configuration (JUnit

## 🧰 Technologies Used

- ☕ Java 17
- 🥒 Cucumber
- 🌿 Serenity BDD
- 🔥 Rest-Assured
- 🐘 Maven V 3.9.9

## 🧬 How It Works
1. 🧾 Test cases are written in **Gherkin syntax** in `.feature` files.
2. 🎯 Each scenario runs as a test using Serenity + Cucumber.
3. 📦 REST requests are made via `SerenityRest`.
4. 📄 Responses are validated using matchers.

### ▶️ Run Tests with Maven

```bash
mvn clean verify
```
## 🧪 Checking Report
- Please go to file://{your-project-path}/target/site/serenity/index.html