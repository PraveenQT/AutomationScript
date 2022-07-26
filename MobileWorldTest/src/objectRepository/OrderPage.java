package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
	
	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	By password=By.id("inputPassword");
	By gender=By.id("flexRadioDefault2");
	By number=By.xpath("//input[@placeholder='00000000000']");
	By addr1=By.id(" address1");
	By addr2=By.id("address2");
	By city=By.id("inputCity");
	By zip=By.id("inputZip");
	By count=By.xpath("//input[@placeholder='no of mobiles']");
	By noOfTimes=By.id("time");
	
	
	public WebElement getEmail()
	{
		return driver.findElement(By.id("inputEmail"));
	}
	
	public WebElement getPass()
	{
		return driver.findElement(password);
	}
	
	public WebElement getGender()
	{
		return driver.findElement(gender);
	}
	
	public WebElement getNumber()
	{
		return driver.findElement(number);
	}
	
	public WebElement getAddr1()
	{
		return driver.findElement(addr1);
	}
	
	public WebElement getAddr2()
	{
		return driver.findElement(addr2);
	}
	
	public WebElement getCity()
	{
		return driver.findElement(city);
	}
	
	public WebElement getZip()
	{
		return driver.findElement(zip);
	}
	
	public WebElement getCount()
	{
		return driver.findElement(By.xpath("//input[@placeholder='no of mobiles']"));
	}
	
	public WebElement getNoOFTimes()
	{
		return driver.findElement(noOfTimes);
	}

}
