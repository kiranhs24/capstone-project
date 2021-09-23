package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp {
	
	WebDriver driver;
	
	public SignUp(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	@FindBy(css="input[name='pwd2']")
	public WebElement confirmPassword;
	
	@FindBy(css="input[name='name']")
	public WebElement name;
	
	@FindBy(css="input[name='address']")
	public WebElement address;
	
	@FindBy(css="input[name='city']")
	public WebElement city;
	
	@FindBy(xpath="//button[contains(text(), 'Signup')]")
	public WebElement signUp;
	
	@FindBy(tagName="body")
	public WebElement error;
	
	@FindBy(xpath="//button[contains(text(), 'Update')]")
	public WebElement update;

}
