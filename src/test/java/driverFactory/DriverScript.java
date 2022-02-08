package driverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import commonFunctions.FunctionLibrary;
import constant.PreConditionsPostCoditions;
import utilities.ExcelFile;

public class DriverScript extends PreConditionsPostCoditions{

	WebDriver driver;
	String input="./TestInput/MyOpencartcart.xls";
	String output="./TestOutput/CartResult.xls";
	//ExtentReports report;
	//ExtentTest test;
	int rc;
	ExcelFile xl;
	public DriverScript() throws Exception
	{
		xl = new ExcelFile(input);
		rc = xl.getrowSize("sheet1");
	}

	@Test(priority = 0)
	public void runMacSearch() throws Exception
	{
		for(int i=1;i<=rc;i++)
		{
			String mailid=xl.getCellData("sheet1",i,0);
			String pass=xl.getCellData("sheet1",i,1);
			FunctionLibrary.verifyLogin(mailid, pass);
			String search=xl.getCellData("sheet1",i,2);
			String product=xl.getCellData("sheet1",i,3);
			FunctionLibrary.verifySearchProduct(search,product);
			FunctionLibrary.verifyCart(product);
			FunctionLibrary.Verifylogout();
		}
	}
}
