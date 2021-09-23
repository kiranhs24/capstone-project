package step_defs;

import java.io.IOException;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.BaseClass;
import pages.Dashboard;
import pages.Home;
import pages.Login;
import pages.SignUp;

public class Hooks extends BaseClass{
	
	@Before("@UI")
	public void beforeHook(Scenario scenario) throws IOException {
		
		scenarioName = scenario.getName();
		BaseClass.initChromeBrowser();
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
		login = PageFactory.initElements(driver, Login.class);
		signUp = PageFactory.initElements(driver, SignUp.class);
		home = PageFactory.initElements(driver, Home.class);
		dashboard = PageFactory.initElements(driver, Dashboard.class); 

	}
	
	@After("@UI")
	public void afterHook() throws IOException, InterruptedException {

		driver.quit();

	}
	
	@Before("@API")
	public void beforeHook2() {
		
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
		
	}
	
	@After("@API")
	public void afterHook2() throws IOException, InterruptedException {

		driver.quit();

	}

}
