# BankingAutomation

Automation project for the **Bank Demo App** using **Appium**, **Maven**, **Cucumber**, **TestNG**, and **Jenkins**.

## Project Overview

This project automates the **Bank Demo App** to perform:

- **Smoke Tests**: Basic login functionality.
- **Regression Tests**: Complete user transactions (login, payment, etc).

Technologies used:

- **Java**
- **Appium**
- **TestNG**
- **Cucumber**
- **Maven**
- **Jenkins**
- **Android Device / Emulator**

## Prerequisites

- Java
- Maven 
- Android SDK and ADB setup
- Appium Server
- Jenkins installed (if CI/CD is required)
- Connected Android device or emulator

## Project Structure

BankingAutomation/
│
├─ src/main/java/pages        # Page Object classes
├─ src/test/java/StepDefinition # Step Definitions
├─ src/test/java/runners      # Test runners (Cucumber + TestNG)
├─ src/test/resources/features # Feature files (Cucumber)
├─ pom.xml                     # Maven Project Object Model
├─ Jenkinsfile                 # CI/CD pipeline configuration
└─ README.md                   # Project documentation

## Setup Instructions

1. **Clone the repository**

git clone https://github.com/Harihareswaran/BankingAutomation.git
cd BankingAutomation

2. **Install dependencies**

mvn clean install

3. **Start Appium server**
   Ensure Appium server is running before executing tests.

4. **Connect Android device**
   Verify device is connected:
   adb devices

## Running Tests

### Run Smoke Tests:
mvn test -Dcucumber.filter.tags="@smoke"

### Run Regression Tests:
mvn test -Dcucumber.filter.tags="@regression"

### Run All Tests:
mvn test

## Jenkins Pipeline

The project is integrated with Jenkins using a **Jenkinsfile**. Pipeline stages include:

1. **Checkout SCM** – Pull code from GitHub.
2. **Tool Installation** – Set Java & Maven.
3. **Build Project** – Compile code using Maven.
4. **Run Smoke Tests** – Execute tests tagged `@smoke`.
5. **Run Regression Tests** – Execute tests tagged `@regression`.
6. **Generate Reports** – Publish  Cucumber reports.

### Handling Failures

* Jenkins uses **exit codes** from Maven commands:

  * `0` → Success
  * Non-zero → Failure (build stops)
* To continue even on test failures:
script {
    try {
        bat 'mvn test -Dcucumber.filter.tags="@smoke"'
    } catch(Exception e) {
        echo "Tests failed, but pipeline continues..."
        currentBuild.result = 'UNSTABLE'
    }
}
  
## Reports

* Screenshots (on failure) are saved via `hooks.AppHooks`
* Jenkins publishes JUnit / Cucumber reports for CI/CD pipelines



