package pageObjects;

import org.openqa.selenium.By;


public class StoreAddressUpdate {
	
	
	public By Proceed_to_checkout = By.xpath("//span[text()='Proceed to checkout']");
	public By update = By.xpath("(//a[@title='Update']//span)[2]");
	public By address = By.xpath("//input[@id='address1']");
	public By save = By.xpath("//span[text()[normalize-space()='Save']]");
	public By get_address = By.xpath("(//li[@class='address_address1 address_address2'])[2]");
	public By checkbox = By.xpath("//input[@type='checkbox']");
	public By pay = By.xpath("//a[@title='Pay by bank wire']");
	public By PTC = By.xpath("(//button[@type='submit']//span)[2]");

	
	
	
	
	
	
}
