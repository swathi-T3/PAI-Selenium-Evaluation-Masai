package testFile;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import POM.RegistrationForm;

public class RegistrationTestFile {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void SetupforExtentreports() {
		ExtentSparkReporter path = new ExtentSparkReporter("RegistrationFormPOM.html");
		report = new ExtentReports();
		report.attachReporter(path);
		
		
	}
	
	@BeforeClass
	void brpwsersetup() {;
		test = report.createTest("Launching Browser and navigates URL");
		driver = new ChromeDriver();
		driver.get("https://way2automation.com/way2auto_jquery/registration.php#load_box");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		test.pass("Opended url");
	}
	@Test
	void ToTest() throws InterruptedException {
		
		RegistrationForm Form = new RegistrationForm(driver);
		
		Form.Firstname("Ram");
		test.pass("Firstname Entered!");
		
		Form.Lastname("Pothineni");
		test.pass("Lastname Entered!!");
		
		Form.Phonenumber("987654342");
		test.pass("Phone number Entered!!!");
		
		Form.Username("Ram_123");
		test.pass("Username Entered!!!!");
		
		Form.Password("Ram@9831");
		test.pass("Password Entered!!!!!");
		
		Form.ConfirmPW("Ram@9831");
		test.pass("Entered and confirmed!");
		
		Form.DDcountry();
		test.pass("Dropdown Selected!");
		
		Form.UploadFile();
		test.pass("File successfully uploaded");
		Thread.sleep(3000);
		
		Form.Checkboxes();
		test.pass("Checkboxes Selected successful");
		
		Form.Submit();
		test.pass("Submitted successfully😍");
		Thread.sleep(3000);
		
		Form.Successfullmessage();
		test.pass("Successfully performed to fill the form");
	}
	
	@AfterClass
	void browserclose() {
		driver.quit();
		report.flush();
	}
}
