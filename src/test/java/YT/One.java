package YT;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class One {
	@Test
	public void testGoogle() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Admin",Keys.ENTER);
		System.out.println(driver.getTitle());
		driver.close();
	}
	@Test
	public void testYoutube()
	{	
		SoftAssert sa=new SoftAssert();
		System.out.println("test youtube");
		WebDriver driver=new ChromeDriver();
		driver.get("http://youtube.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("selenium",Keys.ENTER);
		String expectedTitle="selenium - YouTube";
		String actualTitle=driver.getTitle();
		sa.assertEquals(actualTitle, expectedTitle, "Title mismatch");
		String expectedWidth="558px";
		String actualWidth=driver.findElement(By.xpath("//input[@id='search']")).getCssValue("width");
		sa.assertEquals(actualWidth, expectedWidth, "width mismatch");
		sa.assertAll();
		driver.close();
	}
}

