package YT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpencartProperties {
	@Test
	public void testGoogle() throws Throwable {
		
		Properties p=new Properties();
		p.load(new FileInputStream(".\\Opencart.properties"));;
		WebDriver driver=new ChromeDriver();
		driver.get(p.getProperty("Url"));
		driver.manage().window().maximize();
		driver.findElement(By.xpath(p.getProperty("Fname"))).sendKeys("Swathi");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.close();
	}
}
