package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {
	
	WebDriver driver;
	
	public ContactUsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By userName=By.xpath("//input[@placeholder='Username']");
	By email=By.xpath("//input[@placeholder='Email']");
	By phone=By.xpath("//input[@placeholder='Phone']");
	By msg=By.xpath("//textarea[@placeholder='Message']");
	By submit=By.cssSelector("input[value='Send']");
	
	public WebElement getUserName()
	{
		return driver.findElement(userName);
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPhone()
	{
		return driver.findElement(phone);
	}
	
	public WebElement getMessage()
	{
		return driver.findElement(msg);
	}
	
	public WebElement Submit()
	{
		return driver.findElement(submit);
	}
}
