# A comprehensive full-stack automation project designed to support both UI and API testing,
# aimed at enhancing software quality and reliability.
# May 15th 2025
# Audy Chavarría Arango

## UI Approach

## 🛠 Technologies Used

- Java 17
- Maven
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