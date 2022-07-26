package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username=By.id("username");
	By password=By.id("password");
	
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}

}
