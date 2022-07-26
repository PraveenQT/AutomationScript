package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllMobilesPage {
	
	WebDriver driver;
	public AllMobilesPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By search=By.id("myInput");
	
	public WebElement searchInput()
	{
		return driver.findElement(search);
	}
}
