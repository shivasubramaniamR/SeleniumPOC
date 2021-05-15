package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParabankLogin {
	
	WebDriver driver;
	
	public By username = By.xpath("//input[@name='username']");
	public By password = By.xpath("//input[@name='password']");
	public By SignIn = By.xpath("//input[@type='submit']");
	public By Welcome = By.xpath("//div[@id='leftPanel']/p[1]");
	
	
	
	
	public ParabankLogin(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void login(String uname,String pwd) {
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(SignIn).click();
		
	}

}
