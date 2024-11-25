# Fitpeo Automation Script

This repository contains an automation script developed for testing the Fitpeo website, including functionalities like validating the revenue calculator and other components.

---

## Overview

The automation script is implemented using **Java** and the **Selenium WebDriver** framework. It includes test cases for:

- Launching the Fitpeo application.
- Navigating to the Revenue Calculator.
- Validating slider functionality.
- Updating text field values.
- Selecting CPT codes.
- Validating total recurring reimbursement values.

---

## Requirements

### Software

- **Java Development Kit (JDK) 8** or higher.
- **Maven** (for dependency management).
- **Web Browser**: Google Chrome.

### Dependencies

The required libraries are defined in the **pom.xml** file if using Maven.

---

## File Structure

### Packages

- **com.base**: Contains the `BaseClass` for WebDriver initialization.
- **com.pageObjects**: Contains classes representing various web pages and their respective methods.
- **com.testCases**: Contains test cases to execute functionalities.

### Main Files

- **BaseClass.java**: Initializes the WebDriver and manages setup/teardown.
- **HomePage.java**: Handles navigation to the Fitpeo homepage.
- **RevenueCalculatorPage.java**: Contains methods to interact with the revenue calculator.
- **HomePageTest.java**: Test case for launching and closing the homepage.
- **RevenueCalculatorPageTest.java**: Test case for validating the revenue calculator functionalities.

---

## How to Run the Script

1. Launch the **HomePageTest** to verify the application loads successfully
   - This test initializes the browser, opens the homepage, and closes it.

2. Run the **RevenueCalculatorPageTest** to execute validations for
   - Navigating to the revenue calculator.
   - Interacting with sliders and text fields.
   - Validating CPT selections and reimbursement values.

---

## Notes

- Ensure a stable internet connection as the tests depend on live web pages.
- Update the ChromeDriver version if the Chrome browser updates.
- Modify timeouts in `BaseClass` or specific test steps if elements load slower in your environment.

---

## Output

- Console logs indicating the success or failure of validations.
- Automated interaction with the Fitpeo website, demonstrating the tested functionalities.
