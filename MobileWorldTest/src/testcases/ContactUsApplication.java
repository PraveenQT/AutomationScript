package testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.ContactUsPage;

public class ContactUsApplication {

	@Test(dataProvider="get")
	public void contact(String user,String email,String ph,String msg)
	{
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\praveen.daniel\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.get("https://mobileworld.azurewebsites.net");
		dr.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)dr;
		js.executeScript("window.scrollBy(0,3000)", "");
		
		dr.findElement(By.linkText("Contact Us")).click();
		
		Set<String> handles=dr.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentId=it.next();
		String childId=it.next();
		dr.switchTo().window(childId);
		dr.manage().window().maximize();
		
		
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ContactUsPage con = new ContactUsPage(dr);
		con.getUserName().sendKeys(user);
		con.getEmail().sendKeys(email);
		con.getPhone().sendKeys(ph);
		con.getMessage().sendKeys(msg);
		con.Submit().click();
		
	}
	
	
	@DataProvider(name="get")
	public Object[][] getData()
	{
		Object[][] data=new Object[2][4];
		
		//Positive test case
		data[0][0]="Lakhveer";
		data[0][1]="lakhveersingh1698@gmail.com";
		data[0][2]="9795275511";
		data[0][3]="I am the boss";
		
		//Negative test case
		data[1][0]="Kiran";
		data[1][1]="12gmail.com";
		data[1][2]="995275511";
		data[1][3]="Testing again!!";
		
		return data;
	}
}
