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


import pageObjects.StoreLogin;
import pageObjects.Product_Selection;
import pageObjects.StoreAddressUpdate;
import utilities.Base;
import utilities.CustomListeners;

@Listeners(CustomListeners.class)
public class AddressUpdate extends Base {

	StoreLogin login;
	Base b ;
	Product_Selection ps;
	
	StoreAddressUpdate sau;
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
	public void address_update() {
		
		try {
				
		login = new StoreLogin(b.returnDriver());
		ps = new Product_Selection();
		sau= new StoreAddressUpdate();
		
		b.loadURL(URL);
		Reporter.log("<br>Step 1 : Url Loaded------PASS");
		b.ElementWait(login.SignIn);
				
		b.click(login.SignIn);
		Reporter.log("<br>Step 2 : Signin clicked------PASS");
		
		login.login(b.getMapData("email", 1),b.getMapData("password", 1));
		Reporter.log("<br>Step 3 : Application logged in------PASS");
		
		b.click(ps.TShirts);
		Reporter.log("<br>Step 4 : Tshirt Menu clicked------PASS");
		
		b.mouseOver(ps.Tshirt_Hover);
		Reporter.log("<br>Step 5 : Tshirt Hovered Over------PASS");
		
		b.click(ps.AddToCart);
		Reporter.log("<br>Step 6 : Add to Cart clicked------PASS");
		
		b.click(ps.ProceedToCheckout);
		Reporter.log("<br>Step 7 : Proceed to checkout clicked------PASS");
		
		b.click(sau.Proceed_to_checkout);
		Reporter.log("<br>Step 8 : Proceed to checkout clicked------PASS");
		
		b.click(sau.update);
		Reporter.log("<br>Step 9 : Proceed to update address clicked------PASS");
		
		
		
		b.setText(sau.address, b.getMapData("addressupdate", 1));
		Reporter.log("<br>Step 10 : Proceed to address field edited------PASS");
		
		b.click(sau.save);
		Reporter.log("<br>Step 11 : save button clicked------PASS");
		
		Assert.assertEquals(b.getText(sau.get_address), b.getMapData("addressupdate", 1));
		Reporter.log("<br>Step 12 : Verification of Address Success------PASS");
		
		b.click(sau.Proceed_to_checkout);
		Reporter.log("<br>Step 13 : Proceed to checkout clicked------PASS");
		
		b.click(sau.checkbox);
		Reporter.log("<br>Step 14 : User Agreement Checkbox clicked------PASS");
		
		b.click(sau.PTC);
		Reporter.log("<br>Step 15 : Proceed to checkout clicked------PASS");
		
		
		
		
		
		Assert.assertEquals(b.getText(sau.pay), "Pay by bank wire (order processing will be longer)");
		
		b.screenShot(screenshotFilePath, this.getClass().getName());
		Reporter.log("<br>Step 16 : Validation Successfull------PASS");
		
		}catch (Exception e) {
			Reporter.log("<br>Test Step Failed------FAIL");
			Assert.fail(e.getMessage());
			
			
		}
		
	}
	

	
	
	
	

}
