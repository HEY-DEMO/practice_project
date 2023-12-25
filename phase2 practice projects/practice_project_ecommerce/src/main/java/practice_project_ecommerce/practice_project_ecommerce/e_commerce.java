package practice_project_ecommerce.practice_project_ecommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class e_commerce {
	static WebDriver driver;
	public static void main(String []args) {
		String path = "drivers/msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", path);
//		EdgeOptions options = new EdgeOptions();
//		options.addArguments("--headless");
		driver = new EdgeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.amazon.in/");
		
	}
}
