package pageObjects;

import org.openqa.selenium.By;


public class Product_Selection {
	
	public By Email_address = By.xpath("(//label[text()='Email address'])[2]/following-sibling::input");
	public By password = By.xpath("((//label[text()='Email address'])[2]/following::input)[2]");
	public By SignIn = By.xpath("//a[@title='Log in to your customer account']");
	public By TShirts = By.xpath("(//a[@title='T-shirts'])[2]");
	public By Tshirt_Hover = By.xpath("//span[text()='T-shirts ']/following::img");
	public By AddToCart = By.xpath("//span[text()='Add to cart']");
	public By ProceedToCheckout = By.xpath("//a[@title='Proceed to checkout']//span[1]");
	public By cart = By.xpath("//span[text()='1 Product']");
	
	
	
	
}
