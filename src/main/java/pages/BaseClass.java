package pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static Login login;
	public static SignUp signUp;
	public static Home home;
	public static Dashboard dashboard;
	
	public static String email;
	public static String password;
	
	public static String scenarioName;
	
	public static Properties prop;
	
	public static void initChromeBrowser() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--no-sandbox");
		options.addArguments("--allow-insecure-localhost");
		
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 10);
		driver.get("http://localhost:8100/FlyAway");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
