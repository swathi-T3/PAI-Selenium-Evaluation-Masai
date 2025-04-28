package TestRunnerfiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		features = {"C:\\Users\\Admin\\eclipse-workspace\\PAI-Cucumber\\FeatureFile\\RegistrationForm.feature"},
		glue = "Stepdefinitionfiles"
		
		)


public class Registrationformtestruns extends AbstractTestNGCucumberTests {
	


}
