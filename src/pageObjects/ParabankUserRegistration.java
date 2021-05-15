package pageObjects;

import org.openqa.selenium.By;


public class ParabankUserRegistration {
	
	public By Register = By.xpath("//a[contains(text(),'Register')]");
	public By First_name = By.xpath("//input[@id='customer.firstName']");
	public By Last_name = By.xpath("//input[@id='customer.lastName']");
	public By address = By.xpath("//input[@id='customer.address.street']");
	public By city = By.xpath("//input[@id='customer.address.city']");
	public By state = By.xpath("//input[@id='customer.address.state']");
	public By zip = By.xpath("//input[@id='customer.address.zipCode']");
	public By phone = By.xpath("//input[@id='customer.phoneNumber']");
	public By ssn = By.xpath("//input[@id='customer.ssn']");
	public By username = By.xpath("//input[@id='customer.username']");
	public By password = By.xpath("//input[@id='customer.password']");
	public By confirmpassword = By.xpath("//input[@id='repeatedPassword']");
	public By registerButton = By.xpath("(//input[@class='button'])[2]");
	
	
	public By Welcome = By.xpath("//h1");
	
	
	
	
	
}
