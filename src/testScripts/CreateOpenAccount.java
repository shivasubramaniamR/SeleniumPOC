package testScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.OpenAccount;
import pageObjects.ParabankLogin;

import utilities.Base;
import utilities.CustomListeners;

@Listeners(CustomListeners.class)
public class CreateOpenAccount extends Base {

	ParabankLogin login;
	Base b ;
	OpenAccount oa;
	
	public String screenshotFilePath="";
	public String reportspath="";
	public String URL="";
	public String intialReport = "";
	
	
	
	
	
	@BeforeMethod
	public void load(ITestResult result) throws IOException {
		b = new Base();
		screenshotFilePath = (System.getProperty("user.dir")+File.separator+"src"+File.separator+"libraries"+File.separator+"screenshots"+File.separator).replace("\\", "/") ;
		reportspath=(System.getProperty("user.dir")+File.separator+"src"+File.separator+"libraries"+File.separator+"reports"+File.separator).replace("\\", "/") ;
		URL = b.readfromExcel(0, 1, 0);
		intialReport=(System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"MyStore-emailable-report-template.html").replace("\\", "/") ;
		
		intialize("chrome");
		
		Reporter.setCurrentTestResult(result);
		Reporter.log("Step 1 : Browser Initialized------PASS");
		
		
		
		
	}
	
	@AfterMethod
	public void cleanup(ITestResult result) {
		driver.quit();
		Reporter.setCurrentTestResult(result);
		Reporter.log("<br>Browser Closed------PASS");

	}
	
	@Test(enabled=true)
	public void Parabank_Login() {
		
		try {
				
		login = new ParabankLogin(b.returnDriver());
		oa = new OpenAccount();
		
		b.loadURL(URL);
		Reporter.log("<br>Step 1 : Url Loaded------PASS");
		
		b.ElementWait(login.SignIn);	
		
		
		
		login.login(b.readfromExcel(0, 1, 9),b.readfromExcel(0, 1, 10));
		Reporter.log("<br>Step 2 : Entered username and Password and login button clicked------PASS");
		
		
		b.click(oa.OpenAccount);
		Reporter.log("<br>Step 3 : Open Account clicked------PASS");
		
		b.dropdownSelectText(oa.Dropdown, b.readfromExcel(0, 1, 12));
		Reporter.log("<br>Step 4 : Account Type Selected------PASS");
		
		
		//b.ElementWait(oa.Dropdown1);
		
		//b.dropdownSelectText(oa.Dropdown1, (b.readfromExcel(0, 1, 15)).substring(0, 5));
		
		//b.dropdownSelectindex(oa.Dropdown1, 3);
		//Reporter.log("<br>Step 5 : Existing Account Selected------PASS");
		
		Thread.sleep(6000);
		
		b.click(oa.openaccountsubmit);
		
		Reporter.log("<br>Step 5 : Open New Account clicked------PASS");
		
		
		
				
		Assert.assertEquals(b.getText(oa.Welcomemsg), b.readfromExcel(0, 1, 13));
		Reporter.log("<br>Step 6 : Verified the Welcome Message------PASS");
		
		
		b.writetoExcel(0,1,14,b.getText(oa.accountNumber));
		Reporter.log("<br>Step 7 : Account number written to Excel------PASS");
		
		
		
		b.screenShot(screenshotFilePath, this.getClass().getName());
		Reporter.log("<br>Step 8 : Verificaiton of Account details------PASS");
		
		}catch (Exception e) {
			Reporter.log("<br>Test Step Failed------FAIL");
			Assert.fail(e.getMessage());
			
			
		}
		
	}
	

	
	
	
	

}
