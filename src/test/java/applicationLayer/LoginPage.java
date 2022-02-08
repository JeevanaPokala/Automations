package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//Repository
@FindBy(name="")
WebElement name;
@FindBy(name="")
WebElement pswd;
@FindBy(name="")
WebElement login;

//method
public void verifyLogin(String name,String pswd)
{
	Actions a=new Actions(driver);
	//a.moveToElement(name).click().perform();
	this.pswd.sendKeys(null);
	
	
}


}
