package phase2_practice_project.phase2_practice_project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testing_webelements{
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    @BeforeClass
    public void beforeClass() {
        System.out.println("Opening the browser");

        // Initialize ExtentReports and create a report
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Closing the browser");

        // Flush the report and close the WebDriver
        extent.flush();
        }
    

    @Test
    public void chromeTest() throws MalformedURLException, InterruptedException {
        // Create a new ExtentTest instance for this test method
        test = extent.createTest("Chrome Test", "Testing with Chrome browser");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setPlatform(Platform.WINDOWS);
        cap.setBrowserName("chrome");

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        driver.get("https://www.abhibus.com/");
        web_elements we = new web_elements(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(we.from())).sendKeys("bangalore");
        wait.until(ExpectedConditions.visibilityOf(we.to())).sendKeys("Hyderabad");
        wait.until(ExpectedConditions.elementToBeClickable(we.submit())).click();
        Thread.sleep(4000);
        driver.quit();
        // Log the test status in the report
        test.log(Status.PASS, "Test passed successfully");
    }

    @Test
    public void edgeTest() throws MalformedURLException, InterruptedException {
        // Create a new ExtentTest instance for this test method
        test = extent.createTest("Edge Test", "Testing with Microsoft Edge browser");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setPlatform(Platform.WINDOWS);
        cap.setBrowserName("MicrosoftEdge");

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        driver.get("https://www.abhibus.com/");
        web_elements we = new web_elements(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(we.from())).sendKeys("bangalore");
        wait.until(ExpectedConditions.visibilityOf(we.to())).sendKeys("Hyderabad");
        wait.until(ExpectedConditions.elementToBeClickable(we.submit())).click();
        Thread.sleep(3000);

        driver.quit();

        // Log the test status in the report
        test.log(Status.PASS, "Test passed successfully");
    }
}