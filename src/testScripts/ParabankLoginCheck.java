package testScripts;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import pageObjects.ParabankLogin;

import utilities.Base;
import utilities.CustomListeners;

@Listeners(CustomListeners.class)
public class ParabankLoginCheck extends Base {

	ParabankLogin login;
	Base b ;
	
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
		
		b.loadURL(URL);
		Reporter.log("<br>Step 1 : Url Loaded------PASS");
		
		b.ElementWait(login.SignIn);	
		
		
		
		login.login(b.readfromExcel(0, 1, 9),b.readfromExcel(0, 1, 10));
		Reporter.log("<br>Step 2 : Entered username and Password and login button clicked------PASS");
		
		
		Assert.assertEquals(b.getText(login.Welcome), "Welcome"+" "+b.readfromExcel(0, 1, 1)+" "+b.readfromExcel(0, 1, 2));
		
		
		b.screenShot(screenshotFilePath, this.getClass().getName());
		Reporter.log("<br>Step 8 : Verificaiton of Prodcut selection------PASS");
		
		}catch (Exception e) {
			Reporter.log("<br>Test Step Failed------FAIL");
			Assert.fail(e.getMessage());
			
			
		}
		
	}
	

	
	
	
	

}
