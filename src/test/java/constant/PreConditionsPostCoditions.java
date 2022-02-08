package constant;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class PreConditionsPostCoditions {
	public static WebDriver driver;
	public static Properties config;
	@BeforeSuite
	public void setUp() throws Exception
	{
		driver =new ChromeDriver();
		config=new Properties();
		config.load(new FileInputStream("./PropertyFile/CartCheck.properties"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(config.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@AfterSuite
	public void tearDown()
	{
		driver.close();
	}

}
