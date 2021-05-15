package pageObjects;

import org.openqa.selenium.By;


public class OpenAccount {
	
	public By OpenAccount = By.xpath("//a[contains(text(),'Open New Account')]");
	public By Dropdown = By.xpath("//form[@ng-submit='submit()']//select[1]");
	
	public By Dropdown1 = By.xpath("//form[@ng-submit='submit()']//select[2]");
	
	public By openaccountsubmit = By.xpath("//b[text()='What type of Account would you like to open?']/following::input[1]");
	
	public By Welcomemsg = By.xpath("//h1[@class='title']/following-sibling::p[1]");
	
	public By accountNumber = By.xpath("//b[text()='Your new account number:']/following-sibling::a");
	
	
	
	
	
}
