package YT;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Second {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver =new ChromeDriver();
		driver.get("https://google.com");
		
	}
	@Test(priority=0 )
	public void calc()
	{
	
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("Calculator",Keys.ENTER);
		
	}
	@Test(priority=1)
	public void calender()
	{
	
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("Calender",Keys.ENTER);
		driver.close();
		
	}

}
