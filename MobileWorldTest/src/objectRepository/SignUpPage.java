package objectRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class SignUpPage {
	
	WebDriver driver;
	
	public SignUpPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By firstName=By.xpath("//input[@placeholder='First Name']");
	By lastName=By.xpath("//input[@placeholder='Last Name']");
	By email=By.xpath("//input[@placeholder='Enter Email']");
	By password=By.xpath("//input[@placeholder='Password']");
	By number=By.xpath("//input[@placeholder='91XXXXXXXXXX']");
	By bio=By.xpath("//textarea[@placeholder='Short Bio']");
	
	
	public WebElement getFirstName()
	{
		return driver.findElement(firstName);
	}
	public WebElement getLastName()
	{
		return driver.findElement(lastName);
	}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getNumber()
	{
		return driver.findElement(number);
	}
	public WebElement getBio()
	{
		return driver.findElement(bio);
	}
	
	
	
}
