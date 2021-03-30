package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StoreLogin {
	
	WebDriver driver;
	
	public By Email_address = By.xpath("(//label[text()='Email address'])[2]/following-sibling::input");
	public By password = By.xpath("((//label[text()='Email address'])[2]/following::input)[2]");
	public By SignIn = By.xpath("//a[@title='Log in to your customer account']");
	public By Login = By.xpath("//span[text()[normalize-space()='Sign in']]");
	
	
	
	
	public StoreLogin(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void login(String uname,String pwd) {
		driver.findElement(Email_address).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(Login).click();
		
	}

}
