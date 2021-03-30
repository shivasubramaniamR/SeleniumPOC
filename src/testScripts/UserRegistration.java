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



import pageObjects.StoreUserRegistration;

import utilities.Base;
import utilities.CustomListeners;

@Listeners(CustomListeners.class)
public class UserRegistration extends Base {

	
	Base b ;
	StoreUserRegistration sur;
	public String screenshotFilePath="";
	public String reportspath="";
	public String URL="";
	public String intialReport = "";
	
	
	
	
	
	@BeforeMethod
	public void load(ITestResult result) throws IOException {
		b = new Base();
		screenshotFilePath = (System.getProperty("user.dir")+File.separator+"src"+File.separator+"libraries"+File.separator+"screenshots"+File.separator).replace("\\", "/") ;
		reportspath=(System.getProperty("user.dir")+File.separator+"src"+File.separator+"libraries"+File.separator+"reports"+File.separator).replace("\\", "/") ;
		URL = b.getMapData("URL", 0);
		intialReport=(System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"OrangeHRM-emailable-report-template.html").replace("\\", "/") ;
		
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
				
		
		sur = new StoreUserRegistration();
		b.loadURL(URL);
		Reporter.log("<br>Step 1 : Url Loaded------PASS");
		
			
		
		b.click(sur.Sign_in);
		Reporter.log("<br>Step 2 : Signin clicked------PASS");
		
		b.setText(sur.Email_enter, b.getMapData("email", 1));
		Reporter.log("<br>Step 3 : email entered------PASS");
		
		b.click(sur.Create_account);
		Reporter.log("<br>Step 4 : create account clicked------PASS");
		
		b.genderChoose(b.getMapData("gender", 1), sur.Male, sur.Female);
		Reporter.log("<br>Step 5 : gender choosed------PASS");
		
		b.setText(sur.First_name, b.getMapData("firstname", 1));
		Reporter.log("<br>Step 6 : firstname entered------PASS");
		
		b.setText(sur.Last_name, b.getMapData("lastname", 1));
		Reporter.log("<br>Step 7 : lastname entered------PASS");
		
		b.setText(sur.Password, b.getMapData("password", 1));
		Reporter.log("<br>Step 8 : password entered------PASS");
		
		b.click(sur.day1);
		Reporter.log("<br>Step 9 : day selected------PASS");
		
		b.click(sur.month1);
		Reporter.log("<br>Step 10 : month selected------PASS");
		b.click(sur.year1);
		Reporter.log("<br>Step 11 : year selected------PASS");
		
		
		b.setText(sur.address_firstname, b.getMapData("address_firstname", 1));
		Reporter.log("<br>Step 12 : address firstname entered-----PASS");
		
		b.setText(sur.address_lastname, b.getMapData("address_lastname", 1));
		Reporter.log("<br>Step 12 : address lastname entered------PASS");
		
		b.setText(sur.address, b.getMapData("address", 1));
		Reporter.log("<br>Step 14 : address entered------PASS");
		
		b.setText(sur.city, b.getMapData("city", 1));
		Reporter.log("<br>Step 15 : city entered------PASS");
		
		
		
		b.click(sur.state1);
		Reporter.log("<br>Step 16 : state selected------PASS");
		b.click(sur.year1);
		Reporter.log("<br>Step 17 : year selected------PASS");
		
		
		b.setText(sur.zip, "12345");
		Reporter.log("<br>Step 18 : zip entered-----PASS");
		
		b.setText(sur.phone, "123456789");
		Reporter.log("<br>Step 19 : phone number entered------PASS");
		
		
		
		b.setText(sur.alias, b.getMapData("alias", 1));
		Reporter.log("<br>Step 20 : alais entered------PASS");
		
		b.click(sur.register);
		Reporter.log("<br>Step 21 : register clicked------PASS");
		
		Assert.assertEquals(b.getText(sur.login_details), (b.getMapData("firstname", 1)+" "+b.getMapData("lastname", 1)));
		
		
		b.screenShot(screenshotFilePath, this.getClass().getName());
		Reporter.log("<br>Step 22 : Validating the Registration ------PASS");
		
		}catch (Exception e) {
			Reporter.log("<br>Test Step Failed------FAIL");
			Assert.fail(e.getMessage());
			
			
		}
		
	}
	

	
	
	
	

}
