package Stepdefinitionfiles;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;

public class RegistrationformSteps {
    WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        ExtentSparkReporter path = new ExtentSparkReporter("RegistrationFormCucumberSteps.html");
        report = new ExtentReports();
        report.attachReporter(path);
        driver = new ChromeDriver();
        test = report.createTest(scenario.getName());   // Create one test based on Scenario name
    }

    @Given("User visits URL")
    public void user_visits_url() {
        test.info("Visiting URL");
        driver.get("https://way2automation.com/way2auto_jquery/registration.php#load_box");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("User fills the form")
    public void user_fills_the_form() throws InterruptedException, IOException {
        // No need to recreate test again here. Just continue logging.
        
        // First Name
        driver.findElement(By.name("name")).sendKeys("Ram");
        test.pass("Filled First Name");

        // Last Name
        driver.findElement(By.xpath("(//p//input[@type='text'])[2]")).sendKeys("Pothineni");
        test.pass("Filled Last Name");

        // Radio Buttons
        List<WebElement> Ropts = driver.findElements(By.xpath("//div[@class='radio_wrap']/label"));
        for (WebElement option : Ropts) {
            if (option.getText().equalsIgnoreCase("single")) {
                option.click();
                test.pass("Selected 'Single' radio button");
                break;
            }
        }

        // Checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement box : checkboxes) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", box);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement clickableCheckbox = wait.until(ExpectedConditions.elementToBeClickable(box));
            clickableCheckbox.click();
        }
        test.pass("Selected all Checkboxes");

        // Dropdown
        WebElement DD = driver.findElement(By.tagName("select"));
        Select sel = new Select(DD);
        sel.selectByIndex(1);
        test.pass("Selected Country from Dropdown");

        // Date of Birth
        WebElement month = driver.findElement(By.xpath("//div[@class='time_feild']/select"));
        Select selMonth = new Select(month);
        selMonth.selectByVisibleText("1");

        WebElement day = driver.findElement(By.xpath("(//div[@class='time_feild']/select)[2]"));
        Select selDay = new Select(day);
        selDay.selectByVisibleText("1");

        WebElement year = driver.findElement(By.xpath("(//div[@class='time_feild']/select)[3]"));
        Select selYear = new Select(year);
        selYear.selectByVisibleText("2014");

        test.pass("Selected Date of Birth");

        // Phone Number
        driver.findElement(By.name("phone")).sendKeys("9876543425");
        test.pass("Entered Phone Number");

        // Username
        driver.findElement(By.name("username")).sendKeys("Ram_12");
        test.pass("Entered Username");

        // Email
        driver.findElement(By.name("email")).sendKeys("RamPothineni13@gmail.com");
        test.pass("Entered Email");

        // File Upload
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Admin\\ScreensShotsCaptures\\Ram.png");
        Thread.sleep(2000);
        String uploadPath = driver.findElement(By.xpath("//input[@type='file']")).getAttribute("value");
        if (uploadPath.contains("Ram.png")) {
            test.pass("File Uploaded Successfully");
        } else {
            test.fail("File Upload Failed");
        }

        // Password
        driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys("Ram@123");
        test.pass("Entered Password");

        // Confirm Password
        driver.findElement(By.xpath("//input[@name='c_password']")).sendKeys("Ram@123");
        test.pass("Confirmed Password");

        // Submit
        driver.findElement(By.xpath("//input[@value='submit']")).click();
        test.pass("Clicked the submit");
        
        // submission confirmation message
        TakesScreenshot Ts = (TakesScreenshot) driver;
        File filetemppath = Ts.getScreenshotAs(OutputType.FILE);
        File fileactualpath =  new File("C:\\Users\\Admin\\ScreensShotsCaptures\\FormScreenshot.png");
        FileUtils.copyFile(filetemppath, fileactualpath);
            
        test.fail("Registration Success Message Not Displayed");
        
        Thread.sleep(3000);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (report != null) {
            report.flush();
        }
    }

}
