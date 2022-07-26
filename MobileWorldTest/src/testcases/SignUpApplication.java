package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.SignUpPage;

public class SignUpApplication {

	
	@Test(dataProvider="get")
	public void signUp(String first,String last,String email,String pass,String num,String bio) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\praveen.daniel\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.get("https://mobileworld.azurewebsites.net");
		
		dr.manage().window().maximize();
		Thread.sleep(2000);
		
		dr.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/button")).click();
		dr.findElement(By.linkText("Sign up")).click();
		
		SignUpPage log=new SignUpPage(dr);
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.getFirstName().sendKeys(first);
		log.getLastName().sendKeys(last);
		log.getEmail().sendKeys(email);
		log.getPassword().sendKeys(pass);
		dr.findElement(By.xpath("//input[@type='date']")).sendKeys("24-09-1998");
		dr.findElement(By.xpath("//input[@name='gender']")).click();
		log.getNumber().sendKeys(num);
		log.getBio().sendKeys(bio);
		dr.findElement(By.xpath("//*[@id='myForm']/div[6]/div[2]/button")).click();
		
		
		String msg=dr.switchTo().alert().getText();
		System.out.println(msg);
		Assert.assertEquals(msg,"Hai,"+first+"! Go To SingIn");
		dr.switchTo().alert().accept();
		
		dr.quit();
	}
	
	@DataProvider(name="get")
	public Object[][] getData(){
		Object[][] data=new Object[3][6];
		
		//Positive Test case
		data[0][0]="Praveen";
		data[0][1]="Daniel";
		data[0][2]="PraveenDaniel13@gmail.com";
		data[0][3]="Prav@12123";
		data[0][4]="952608488";
		data[0][5]="Rahul Mai";
		
		//Negative Test case
		data[1][0]="Haritha";
		data[1][1]="Daniel";
		data[1][2]="harithathaDaniel13gmail.com";
		data[1][3]="Prav@123";
		data[1][4]="9526085658eee";
		data[1][5]="Haritha testing";
		
		//Negative Test case;
		data[2][0]="Arjun";
		data[2][1]="";
		data[2][2]="arjunakhiljefin3";
		data[2][3]="Jefin@123";
		data[2][4]="95260846436";
		data[2][5]="Akhil testing";
		return data;
	}

}
