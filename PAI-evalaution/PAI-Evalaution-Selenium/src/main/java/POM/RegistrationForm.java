package POM;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;





public class RegistrationForm {
	
	WebDriver driver; 
	public RegistrationForm(WebDriver driver) // class level driver 
	{
		this.driver = driver; // how differntiate local variables and global variables  ==> using this keyword
	}
	
	

	By firstname= By.xpath("(//input[@type='text'])[1]");
	By lastname = By.xpath("(//input[@type='text'])[2]");
	By phonenumber = By.xpath("(//input[@type='text'])[3]");
	By username=  By.xpath("(//input[@type='text'])[4]");
	By password  = By.xpath("(//input[@name='password'])[1]");
	By confirmPW = By.xpath("//input[@name='c_password']");
	By dropdown = By.xpath("(//select[@name])[1]");
	By uploadfile = By.xpath("//input[@type='file']");
	By checkboxex = By.xpath("//input[@type='checkbox']");
	By submit = By.xpath("(//input[@type='submit'])[1]");
	
	
	public void Firstname(String Fname) {
		
		driver.findElement(firstname).sendKeys(Fname);
		
	}
	public void Lastname(String Lname) {
		
		driver.findElement(lastname).sendKeys(Lname);
		
	}
	public void Phonenumber(String number) {
		
		driver.findElement(phonenumber).sendKeys(number);
		
	}
	public void Username(String user) {
		
		driver.findElement(username).sendKeys(user);
	
	}
	public void Password(String pass) {
		
		driver.findElement(password).sendKeys(pass);
		
	}
	public void ConfirmPW(String CPW) {
		
		driver.findElement(confirmPW).sendKeys(CPW);
		
	}
	public void DDcountry() {
		
		driver.findElement(dropdown).click();
		
		 WebElement DD = driver.findElement(By.tagName("select"));
		Select sel = new Select(DD);
		sel.selectByContainsVisibleText("India");
		
		
	}
	
	public void UploadFile() throws InterruptedException {
		
		driver.findElement(uploadfile).sendKeys("C:\\Users\\Admin\\ScreensShotsCaptures\\Ram.png");
		Thread.sleep(3000);
		
		String uploadpath = driver.findElement(By.xpath("//input[@type='file']")).getAttribute("value");
		if(uploadpath.contains("Ram.png")){
			System.out.println("File uploaded successfully");
			
			
		} else {
			System.out.println("File upload failed");
			
		}
	}
	
	public void Checkboxes() {
		
		driver.findElement(checkboxex).click();
		

	}
	
	public void Submit() {
		
		driver.findElement(submit).click();
		
	}
	public void Successfullmessage() {
		
		System.out.println("Form successfully filled");
		
	}
	

	
}























