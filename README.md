# PAI-Selenium-Evaluation-Masai
## Automation Testing
### Description
This evaluation focuses on Automation Testing of different web applications, combining Selenium WebDriver with advanced frameworks and tools.

### Technologies & Tools Used
- Selenium WebDriver
  - For browser automation
- TestNG
   - For test execution and assertions
- Page Object Model (POM)
   - For better test maintenance and reusability
- BDD with Cucumber 
    - For behavior-driven testing
- ExtentReports 
    - For rich HTML reporting
- Java 
    - Programming language
- Maven
    - Project management and dependency handling

### Applications Covered

*Way2Automation Website*
  - URL: [Way2Automation Registration](https://way2automation.com/way2auto_jquery/registration.php#load_box)
  - Focus:
      - Form filling automation, validation testing.

*PracticeTestAutomation Website*
  - URL: [Practice Test Login](https://practicetestautomation.com/practice-test-login/)
  - Focus:
    - Login functionality testing.
    - Implemented Data-Driven Testing using TestNG DataProvider.
  
*API Testing on JSONPlaceHolder*
  - URL: [JSONPlaceholder API](https://jsonplaceholder.typicode.com/)
  - Focus:
      - REST API testing using automation scripts.
      - Validated responses like GET, POST, etc.
  ---
  ## 🗂️ Project Structure
  ### 📁 DataproviderPTAsite
  *DataproviderPTAsite*
  
    ├── src/test/java
    │   └── DataProvider
    │       └── Login.java
    ├── src/test/resources
    ├── pom.xml

📁 PAI-Evaluation-Selenium
*PAI-Evaluation-Selenium*

    ├── src/main/java
    │   └── POM
    │       └── RegistrationForm.java
    ├── src/test/java
    │   └── testFile
    │       └── RegistrationTestFile.java
    ├── RegistrationFormPOM.html (Extent Report)
    ├── pom.xml

  📁 PAI-Cucumber
  *PAI-Cucumber*
  
    ├── src/main/java
    │   └── Stepdefinitionfiles
    │       └── RegistrationformSteps.java
    ├── src/test/java
    │   └── TestRunnerfiles
    │       └── Registrationformtestruns.java
    ├── FeatureFile
    │   └── RegistrationForm.feature
    ├── RegistrationFormCucumberSteps.html (Extent Report)
    ├── pom.xml
  --- 
###  How to Run
1. Clone the repository:
     ```git clone https://github.com/swathi-T3/PAI-Selenium-Evaluation-Masai.git```
2. Navigate into any module:
     ```cd DataproviderPTAsite```
3. Run the tests using:
     ```mvn test```
--- 
###  Reports
Test reports are auto-generated and saved in the ```test-output/``` directory or HTML files ```(.html)``` at the project root.

### Key Highlights
- Built a robust, maintainable test framework using Page Object Model (POM).
- Implemented Data-Driven Testing using TestNG DataProviders for different login scenarios.
- Covered positive and negative test cases for form validations and login functionality.
- Integrated ExtentReports for detailed and colorful HTML reporting.
- Performed basic API Testing validating HTTP requests and responses.

### Conclusion 
This evaluation showcases a comprehensive approach to automation testing by integrating multiple testing strategies and tools. From simple login validation using DataProvider and TestNG, to form automation with POM and ExtentReports, and finally implementing BDD with Cucumber, it covers essential testing practices used in real-world scenarios. This evaluation not only demonstrates hands-on proficiency in Selenium-based automation but also emphasizes clean code architecture, reusability, and robust reporting.
