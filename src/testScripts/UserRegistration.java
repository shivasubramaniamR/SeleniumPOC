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



import pageObjects.ParabankUserRegistration;

import utilities.Base;
import utilities.CustomListeners;

@Listeners(CustomListeners.class)
public class UserRegistration extends Base {

	
	Base b ;
	ParabankUserRegistration sur;
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
	public void user_registration() {
		
		try {
				
		
		sur = new ParabankUserRegistration();
		b.loadURL(URL);
		Reporter.log("<br>Step 1 : Url Loaded------PASS");
		
		
		
		//b.ElementWait(sur.Register);	
		
		b.click(sur.Register);
		Reporter.log("<br>Step 2 : Register Link clicked------PASS");
		
		b.ElementWait(sur.First_name);	
		
		b.setText(sur.First_name, b.readfromExcel(0, 1, 1));
		Reporter.log("<br>Step 3 : Firstname entered------PASS");
		
		b.setText(sur.Last_name, b.readfromExcel(0, 1, 2));
		Reporter.log("<br>Step 4 : Lastname entered------PASS");
		
		b.setText(sur.address, b.readfromExcel(0, 1, 3));
		Reporter.log("<br>Step 5 : Address entered------PASS");
		
				
		b.setText(sur.city, b.readfromExcel(0, 1, 4));
		Reporter.log("<br>Step 6 : City entered------PASS");
		
		b.setText(sur.state, b.readfromExcel(0, 1, 5));
		Reporter.log("<br>Step 7 : State entered------PASS");
		
		b.setText(sur.zip, b.readfromExcel(0, 1, 6));
		Reporter.log("<br>Step 8 : Zipcode entered------PASS");
		
		b.setText(sur.phone, b.readfromExcel(0, 1, 7));
		Reporter.log("<br>Step 9 : Phone entered------PASS");
		
		b.setText(sur.ssn, b.readfromExcel(0, 1, 8));
		Reporter.log("<br>Step 10 : SSN entered------PASS");
		
		b.setText(sur.username, b.readfromExcel(0, 1, 9));
		Reporter.log("<br>Step 11 : Username entered------PASS");
		
		b.setText(sur.password, b.readfromExcel(0, 1, 10));
		Reporter.log("<br>Step 12 : Password entered------PASS");
		
		b.setText(sur.confirmpassword, b.readfromExcel(0, 1, 11));
		Reporter.log("<br>Step 13 : Confirm Password entered------PASS");
		
		
		
		b.click(sur.registerButton);
		Reporter.log("<br>Step 14 : Register Button clicked------PASS");
		
		
		
		
		Assert.assertEquals(b.getText(sur.Welcome), ("Welcome"+" "+b.readfromExcel(0, 1, 9)));
		
		
		b.screenShot(screenshotFilePath, this.getClass().getName());
		Reporter.log("<br>Step 15 : Validating the Registration ------PASS");
		
		}catch (Exception e) {
			Reporter.log("<br>Test Step Failed------FAIL");
			Assert.fail(e.getMessage());
			
			
		}
		
	}
	

	
	
	
	

}
