package DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	
	
	@Test(dataProvider = "gettestdata")
	public void Loginfunctionality(String username, String password) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("submit")).click();
		
		//To validate login success or failure using : Assertions
		String url = driver.getCurrentUrl();
		if(url.contains("logged-in-successfully")) {
			System.out.println("Login successful for username and password: " + username + " and " + password);
			Assert.assertTrue(url.contains("logged-in-successfully"), "Login successful");
			driver.findElement(By.linkText("Log out")).click();
			String loginurl = driver.getCurrentUrl();
			Assert.assertTrue(loginurl.contains("practice-test-login"), "Redirected to the login page");				
		}else {
			
			 System.out.println("Login failed for username: " + username + " and " +  password);
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			 
			 WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
			    
			 String actualErrorMessage = errorElement.getText();
			 System.out.println("Error Message: " + actualErrorMessage); 
			    // Assertion to verify the correct error message
			    if (username.trim().equals("student")) {
			        // Username is correct but password is wrong
			        Assert.assertEquals(actualErrorMessage.trim(), "Your password is invalid!", "Password error message mismatch");
			    } else {
			        // Username is wrong
			        Assert.assertEquals(actualErrorMessage.trim(), "Your username is invalid!", "Username error message mismatch");
			    }
	         
			
			
		}
			
		Thread.sleep(3000);
		driver.quit();
	}
		
		//To Use DataProvider needs to create object using Object class
		@DataProvider
		public Object [][] gettestdata()
		{
			Object[][] values = new Object[3][2];
			values[0][0] = "student";
			values[0][1] = "Password123";
			values[1][0] = "incorrectUser";
			values[1][1] = " Password123";
			values[2][0] = "student";
			values[2][1] = " incorrectPassword";
			
			return values;
		}
		
		
	

}
