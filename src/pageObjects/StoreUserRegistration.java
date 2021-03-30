package pageObjects;

import org.openqa.selenium.By;


public class StoreUserRegistration {
	
	public By Sign_in = By.xpath("//a[@title='Log in to your customer account']");
	public By Email_enter = By.xpath("//input[contains(@id,'email_create')]");
	public By Create_account = By.xpath("//span[text()[normalize-space()='Create an account']]");
	public By Male = By.xpath("(//input[@name='id_gender'])[1]");
	public By Female = By.xpath("(//input[@name='id_gender'])[2]");
	public By First_name = By.xpath("//input[(@id='customer_firstname')]");
	public By Last_name = By.xpath("//input[(@id='customer_lastname')]");
	public By Password = By.xpath("//input[(@id='passwd')]");
	public By days = By.xpath("//div[(@id='uniform-days')]");
	public By months = By.xpath("//select[@id='months']");
	public By years = By.xpath("//div[(@id='uniform-years')]");
	public By address_firstname = By.xpath("//input[(@id='firstname')]");
	public By address_lastname = By.xpath("//input[(@id='lastname')]");
	public By address = By.xpath("//input[(@id='address1')]");
	public By city = By.xpath("//input[(@id='city')]");
	public By state = By.xpath("//div[(@id='uniform-id_state')]");
	public By country = By.xpath("//div[(@id='uniform-id_country')]");
	public By phone = By.xpath("//input[(@id='phone_mobile')]");
	public By alias = By.xpath("//input[(@id='alias')]");
	public By zip = By.xpath("//input[@id='postcode']");
	public By register = By.xpath("//span[text()='Register']");
	public By login_details = By.xpath("//a[@title='View my customer account']//span[1]");
	
	public By day1 = By.xpath("//select[@id='days']/option[4]");
	public By year1 = By.xpath("//select[@id='years']/option[30]");
	public By month1 = By.xpath("//select[@id='months']/option[3]");
	
	public By state1 = By.xpath("//select[@id='id_state']/option[3]");
	public By country1 = By.xpath("//select[@id='id_country']/option[1]");
	
	
	
	
}
