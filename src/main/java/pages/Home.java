package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Home {
	
	WebDriver driver;

	public Home(WebDriver driver) {

		this.driver = driver;

	}
	
	@FindBy(xpath="//a[contains(@href, 'home')]")
	public WebElement home;
	
	@FindBy(xpath="//a[contains(@href, 'login')]")
	public WebElement loginSignup;

	@FindAll(value = { @FindBy(xpath="//a[contains(@href, 'bookflight')]") })
	public List<WebElement> flights;
	
	@FindBy(css="select[name='source']")
	public WebElement source;
	
	@FindBy(css="select[name='destination']")
	public WebElement destination;
	
	@FindBy(xpath = "//button[contains(text(), 'Submit')]")
	public WebElement submit;
	
	@FindBy(css="table[border='1']")
	public WebElement airlines;
	
}
