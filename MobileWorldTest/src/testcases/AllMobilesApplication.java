package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.AllMobilesPage;

public class AllMobilesApplication {
	
	@Test(dataProvider="get")
	public void AllMobiles(String value)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\praveen.daniel\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.get("https://mobileworld.azurewebsites.net");
		dr.findElement(By.linkText("All Mobiles")).click();
		
		AllMobilesPage al=new AllMobilesPage(dr);
		al.searchInput().sendKeys(value);
		
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		String name=dr.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[7]/td[1]")).getText().toString();
		System.out.println(name);
	}
	
	@DataProvider(name="get")
	public Object[][] getData()
	{
		Object[][] data=new Object[3][1];
		data[0][0]="len";
		data[1][0]="app";
		data[2][0]="sam";
		return data;
	}

}
