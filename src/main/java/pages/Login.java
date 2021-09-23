package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
	WebDriver driver;
	
	public Login(WebDriver driver) {

		this.driver = driver;
		
	}
	
	@FindBy(css="input[name='email_id']")
	public WebElement email;
	
	@FindBy(css="input[name='pwd']")
	public WebElement password;
	
	@FindBy(tagName="button")
	public WebElement login;
	
	@FindBy(xpath="//a[contains(@href, 'signup')]")
	public WebElement signUp;

}
