package project_file_upload_and_handle_webelements;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class upload_file {
	static WebDriver driver = null;
	@SuppressWarnings("deprecation")
	public static void main(String []args ) throws IOException,InterruptedException {
		
		//setting the driver path
		String path = "drivers/msedgedriver.exe";
		System.setProperty("webdriver.edge.driver",path );
		
		
		//initiating driver
		driver = new EdgeDriver();
		
		//loading the webpage
		driver.get("https://anonymfile.com/");
		
		//taking screenshot of loaded webpage 
		takescreenshot("Webpage loaded.png");
		
		//locating web element
		WebElement d = driver.findElement(By.id("expire"));
		
		Select s = new Select(d);
		
		//selecting item from dropdown
		s.selectByIndex(1);
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//taking screenshot after handling the dropdown menu
		takescreenshot("handling dropdown element.png");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/div[2]/div[1]/label")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("autoit\\upload.exe");
		Thread.sleep(3000);
		
		//taking screenshot of uploaded file
		takescreenshot("uploaded file using auto it.png");
		
		//closing the browser
		driver.close();

	}
	//creating a seperate method call for multiple screenshots
	private static void takescreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(ss, new File("Screenshots\\"+filename));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
