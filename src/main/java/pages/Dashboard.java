package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard {
	
	
	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	@FindBy(xpath="//a[contains(@href, 'home')]")
	public WebElement home;
	
	@FindBy(xpath="//a[contains(@href, 'dashboard')]")
	public WebElement dashboard;
	
	@FindBy(xpath="//a[contains(@href, 'edit')]")
	public WebElement editProfile;
	
	@FindBy(xpath="//a[contains(@href, 'bookings')]")
	public WebElement bookings;
	
	@FindBy(xpath="//a[contains(@href, 'logout')]")
	public WebElement logout;
	
	@FindBy(xpath="//a[contains(@href, 'completepurchase')]")
	public WebElement completePurchase;
	
	@FindBy(xpath="//h3[contains(text(), 'BOOKING CONFIRMATION')]")
	public WebElement bookingConfirmation;

}
