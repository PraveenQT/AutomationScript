package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.LoginPage;

public class LoginApplication {
	
	@Test(dataProvider="set")
	public void loginPage(String user,String pass) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\praveen.daniel\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.get("https://mobileworld.azurewebsites.net");
		
		dr.manage().window().maximize();
		Thread.sleep(2000);
		
		dr.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/button")).click();
		
		LoginPage lp=new LoginPage(dr);
		lp.getUsername().sendKeys(user);
		lp.getpassword().sendKeys(pass);
		
		dr.findElement(By.linkText("Log In")).click();
	
		
		dr.quit();
		
		
	}
	
	@DataProvider(name="set")
	public Object[][] getData(){
		Object[][] data= new Object[2][2];
		data[0][0]="srihari";
		data[0][1]="and@123";
		
		
		data[1][0]="rakshitha123";
		data[1][1]="minions@456";
		
		return data;
	}

}
