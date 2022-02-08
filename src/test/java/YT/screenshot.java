package YT;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class screenshot {
	WebDriver driver;
	@Test
	public void screen() throws Exception
	{
		driver=new ChromeDriver();
		driver.get("https://facebook.com");
		//Call getScreenshotAs method to create image file
		File SrcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// Open the current date and time
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		
		//Move image file to new destination
		File DestFile=new File("./screenshots/home"+timestamp+".png");

		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		
		driver.close();
	}
	
}
