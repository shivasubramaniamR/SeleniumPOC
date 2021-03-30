package pageObjects;

import org.openqa.selenium.By;


public class StorePayment {
	
	
	public By Proceed_to_checkout = By.xpath("(//button[@type='submit']//span)[2]");
	public By pay = By.xpath("//a[@title='Pay by bank wire']");
	public By confirm = By.xpath("(//button[@type='submit']//span)[2]");
	public By backToOrders = By.xpath("//a[@title='Back to orders']");
	public By order_lists = By.xpath("//table[@id='order-list']//tr");
	

	
	
	
	
	
	
}
