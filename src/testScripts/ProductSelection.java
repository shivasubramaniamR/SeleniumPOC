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
import utilities.Base;
import utilities.CustomListeners;

@Listeners(CustomListeners.class)
public class ProductSelection extends Base {

	StoreLogin login;
	Base b ;
	Product_Selection ps;
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
	public void Product_Selection() {
		
		try {
				
		login = new StoreLogin(b.returnDriver());
		ps = new Product_Selection();
		b.loadURL(URL);
		Reporter.log("<br>Step 1 : Url Loaded------PASS");
		
			
		
		b.click(login.SignIn);
		Reporter.log("<br>Step 2 : Signin clicked------PASS");
		
		login.login(b.getMapData("email", 1),b.getMapData("password", 1));
		Reporter.log("<br>Step 3 : Application logged in------PASS");
		
		b.click(ps.TShirts);
		Reporter.log("<br>Step 4 : Tshirt Menu clicked------PASS");
		
		b.mouseOver(ps.Tshirt_Hover);
		Reporter.log("<br>Step 5 : Tshirt Hoverd over------PASS");
		
		b.click(ps.AddToCart);
		Reporter.log("<br>Step 6 : Add to cart clicked------PASS");
		
		b.click(ps.ProceedToCheckout);
		Reporter.log("<br>Step 7 : proceed to Checkout clicked------PASS");
		
		Assert.assertEquals(b.getText(ps.cart), "1 Product");
		
		
		b.screenShot(screenshotFilePath, this.getClass().getName());
		Reporter.log("<br>Step 8 : Verificaiton of Prodcut selection------PASS");
		
		}catch (Exception e) {
			Reporter.log("<br>Test Step Failed------FAIL");
			Assert.fail(e.getMessage());
			
			
		}
		
	}
	

	
	
	
	

}
