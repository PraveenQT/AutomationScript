package testcases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.OrderPage;

public class OrderApplication {
	
	
	@Test(dataProvider="get")
	public void orderMe(String first,String last,String email,String pass,String num,String addr1,String addr2,String city,String zip,String count ) {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\praveen.daniel\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.get("https://mobileworld.azurewebsites.net");
	
		dr.manage().window().maximize();
		
		dr.findElement(By.xpath("/html/body/nav/div/ul/li[4]/a")).click();
		dr.findElement(By.linkText("Order")).click();
		
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Window Handling
		Set <String> currentHandle= dr.getWindowHandles();
		Iterator<String> it=currentHandle.iterator();
		String parentId=it.next();
		String childId=it.next();
		dr.switchTo().window(childId);
		
		OrderPage ord=new OrderPage(dr);
		
		List<WebElement> list=dr.findElements(By.id("inputFirstName"));
		list.get(0).sendKeys(first);
		list.get(1).sendKeys(last);
		
		
		ord.getEmail().sendKeys(email);
		ord.getPass().sendKeys(pass);
		ord.getGender().click();
		ord.getNumber().sendKeys(num);
		ord.getAddr1().sendKeys(addr1);
		ord.getAddr2().sendKeys(addr2);
		ord.getCity().sendKeys(city);
		
		
		WebElement drop=dr.findElement(By.id("inputState"));
		Select staticDrop=new Select(drop);
		staticDrop.selectByIndex(2);
		
		ord.getZip().sendKeys(zip);
		dr.findElement(By.xpath("//input[@rel='samsung']")).click();
		dr.findElement(By.xpath("//input[@rel='apple']")).click();
		dr.findElement(By.xpath("//*[@id=\"apple\"]")).click();
		ord.getCount().sendKeys(count);
		
		WebElement drop1=dr.findElement(By.id("bought"));
		Select staticDrop1=new Select(drop1);
		staticDrop1.selectByVisibleText("No");
		
		List<WebElement> list1=dr.findElements(By.id("gridCheck1"));
		list1.get(0).click();
		list1.get(1).click();
		
		dr.findElement(By.xpath("//button[@data-toggle='modal']")).click();
		
		//dr.switchTo().alert().accept();
		dr.findElement(By.cssSelector("#exampleModal > div > div > div.modal-footer > a")).click();
		dr.quit();
		
		
		
		}
	
	@DataProvider(name="get")
	public Object[][] getData()
	{
		Object[][] data=new Object[2][10];
		
		//Positive test case
		data[0][0]="Napolean";
		data[0][1]="Elizabeth";
		data[0][2]="napo@123gmail.com";
		data[0][3]="23124";
		data[0][4]="92824924";
		data[0][5]="asfsafas";
		data[0][6]="safdasfsaf";
		data[0][7]="safsaf";
		data[0][8]="1422";
		data[0][9]="4";
		
		//Negative test case
		data[1][0]="Meghana";
		data[1][1]="Shekhar";
		data[1][2]="meghana@gmail.com";
		data[1][3]="12345678";
		data[1][4]="94738628297";
		data[1][5]="Kengeri";
		data[1][6]="nagarbhavi";
		data[1][7]="Bangalore";
		data[1][8]="562047";
		data[1][9]="";
		
		return data;
	}

}
