package phase2_practice_project.phase2_practice_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class web_elements  {
	WebDriver driver;
	public web_elements(WebDriver driver) {
		this.driver = driver;
	}
	By start = By.xpath("//*[@id=\"search-from\"]/div/div/div/div/div[2]/input");
	By end = By.xpath("//*[@id=\"search-to\"]/div/div/div/div/div[2]/input");
	By search = By.xpath("//*[@id=\"jaurney-date\"]/div/div/div/div[3]/a[2]");
	By date = By.xpath("//*[@id=\"jaurney-date\"]/div/div/div/div[2]/input");
	public WebElement from() {
		return driver.findElement(start);
	}
	public WebElement to() {
		return driver.findElement(end);
	}
	public WebElement submit() {
		return driver.findElement(search);
	}
	public WebElement when() {
		return driver.findElement(date);
	}
}
