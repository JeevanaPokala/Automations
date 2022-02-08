package commonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import constant.PreConditionsPostCoditions;

public class FunctionLibrary extends PreConditionsPostCoditions {
	

	public static boolean verifyLogin(String email,String pass) throws Exception
	{
		driver.findElement(By.xpath(config.getProperty("LocMyAccount"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(config.getProperty("LocLogin"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(config.getProperty("LocEmail"))).sendKeys(email);
		driver.findElement(By.xpath(config.getProperty("LocPassword"))).sendKeys(pass);
		driver.findElement(By.xpath(config.getProperty("LocLoginButton"))).click();
		// Comparing Actual and Expected Tittle
		String expectedTitle="My Account";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equalsIgnoreCase(actualTitle))
			return true;
		else
			return false;
	}
	public static boolean verifySearchProduct(String searchText,String productName )
	{
		driver.findElement(By.xpath(config.getProperty("LocSearch"))).sendKeys(searchText);
		driver.findElement(By.xpath(config.getProperty("LocSearchButton"))).click();
		WebElement macBookAir=driver.findElement(By.xpath(config.getProperty("LocMacBookAir")));
		String actualProductName=macBookAir.getAttribute("href");
		// Comparing Actual and Expected Product Search
		if(productName.equalsIgnoreCase(actualProductName))
		{
			driver.findElement(By.xpath(config.getProperty("LocAddToCart"))).click();
			return true;
		}
		else
			return false;
	}
	public static boolean verifyCart(String productName )
	{
		driver.findElement(By.xpath(config.getProperty("LocViewCart"))).click();
		driver.findElement(By.xpath(config.getProperty("LocViewCartButton"))).click();
		WebElement cartMacBookAir=driver.findElement(By.xpath(config.getProperty("LocCartBody")));
		String actualProductName=cartMacBookAir.getAttribute("href");
		// Comparing Actual and Expected Product in cart 
		if(productName.equalsIgnoreCase(actualProductName))
		{
			driver.findElement(By.xpath(config.getProperty("LocAddToCart"))).click();
			return true;
		}
		else
			return false;

	}
	public static void Verifylogout()
	{
		driver.findElement(By.xpath(config.getProperty("LocMyAccount"))).click();
		driver.findElement(By.xpath(config.getProperty("Loclogout"))).click();
	}
}
