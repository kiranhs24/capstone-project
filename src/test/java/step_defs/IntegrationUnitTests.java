package step_defs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.UUID;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import db_connection.DBConnection;
import pages.BaseClass;
import pages.Dashboard;
import pages.Home;
import pages.Login;
import pages.SignUp;
import utilities.Utilities;

public class IntegrationUnitTests extends BaseClass {

	DBConnection conn;
	Statement stmt;
	
	static int placeId;
	static String place;
	
	static int airlineId;
	static String airlineName;
	
	static int flightId;
	
	static int userId;
	static String emailId;
	static String password;
	
	static int bookingId;

	protected static final Logger logger = LogManager.getLogger(IntegrationUnitTests.class.getName());

	@Given("^A new \"([^\"]*)\" is added from backend$")
	public void a_new_is_added_from_backend(String type) throws Throwable {
		
		logger.info("======== " + scenarioName + " ========");
		
		prop = Utilities.readPropertiesFiles("db_config.properties");
		Random random = new Random();
		conn = new DBConnection(prop.getProperty("url"), prop.getProperty("userid"), prop.getProperty("password"));
		logger.info("Connecting to database");

		try {

			conn.getConnection().setAutoCommit(false);
			logger.info("Connected to database");
			stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate("use flyaway");
			logger.info("Selected Database - flyaway");

			if (type.equalsIgnoreCase("airline")) {
				
				airlineId = random.nextInt(100000);
				airlineName = "Airline " + UUID.randomUUID().toString().substring(0, 5);
				logger.info("Airline - " + airlineName);
				logger.info("Airline ID - " + airlineId);
				stmt.executeUpdate("INSERT INTO `f_airlines` VALUES (" + airlineId + ",'" + airlineName + "')");
				logger.info("Inserted a new airline");

			} else if (type.equalsIgnoreCase("place")) {

				placeId = random.nextInt(100000);
				place = "Place " + UUID.randomUUID().toString().substring(0, 5);
				logger.info("Place - " + place);
				logger.info("Place ID - " + placeId);
				stmt.executeUpdate("INSERT INTO `f_places` VALUES (" + placeId + ",'" + place + "')");
				logger.info("Inserted a new place");

			} else if(type.equalsIgnoreCase("flight")) {
				
				flightId = random.nextInt(100000); 
				stmt.executeUpdate("INSERT INTO `f_flights` VALUES (" + flightId + "," + placeId + ",4," + airlineId + ",'1 pm','3 pm','2 hours',20000.00)");
				logger.info("Inserted a new flight");
				
			} else if(type.equalsIgnoreCase("user")) {
				
				userId = random.nextInt(100000);
				logger.info("User ID - " + userId);
				emailId = "kiran" + UUID.randomUUID().toString().replace("-", "") + "@kiran.com";
				logger.info("Email ID - " + emailId);
				password = "kiran";
				logger.info("Password - " + password);
				stmt.executeUpdate("INSERT INTO `f_user` VALUES (" + userId + ",'Kiran HS','" + emailId + "','2019-07-05 17:40:10','This is my address','this is my city','" + password + "')");
				logger.info("Inserted new user");
				
			} else if (type.equalsIgnoreCase("booking")) {
				
				bookingId = random.nextInt(20);
				logger.info("Booking ID - " + bookingId);
				stmt.executeUpdate("INSERT INTO `f_bookings` VALUES(" + bookingId + "," + userId + "," + flightId + ",20000.00,'2019-07-05 19:07:11','2019-09-05 19:07:11')");
				logger.info("Insterted a new booking for user with ID - " + userId);
				
			}
			
			conn.getConnection().commit();
			stmt.close();
			conn.closeConnection();

		} catch (SQLException e) {

			e.printStackTrace();

			try {

				conn.getConnection().rollback();

			} catch (SQLException message) {

				logger.info("Rollback Messsage");

			}

		}

	}

	@When("^Checked in UI$")
	public void checked_in_UI() throws Throwable {
		
		BaseClass.initChromeBrowser();
		login = PageFactory.initElements(driver, Login.class);
		signUp = PageFactory.initElements(driver, SignUp.class);
		home = PageFactory.initElements(driver, Home.class);
		dashboard = PageFactory.initElements(driver, Dashboard.class);

	}

	@Then("^The added \"([^\"]*)\" should reflect on the UI$")
	public void the_added_should_reflect_on_the_UI(String type) throws Throwable {
		
		if(type.equalsIgnoreCase("place")) {
			
			Select source = new Select(home.source);
			source.selectByVisibleText(place);
			Assert.assertEquals(source.getFirstSelectedOption().getText(), place);
			
		} else if(type.equalsIgnoreCase("flight")) {
			
			Select source = new Select(home.source);
			source.selectByVisibleText(place);
			logger.info("Selected " + place + " as source");
			
			Select destination = new Select(home.destination);
			destination.selectByVisibleText("Chennai");
			logger.info("Selected Chennai as destination");
			
			home.submit.click();
			logger.info("Clicked on submit");
			
			Assert.assertTrue(home.flights.get(0).isDisplayed());
			
		} else if(type.equalsIgnoreCase("user")) {
			
			home.loginSignup.click();
			logger.info("Clicked on login / signup");
			login.email.sendKeys(emailId);
			login.password.sendKeys(password);
			login.login.click();
			logger.info("Clicked on login");
			
			Assert.assertTrue(dashboard.editProfile.isDisplayed());
			
		} else if(type.equalsIgnoreCase("booking")) {
			
			home.loginSignup.click();
			logger.info("Clicked on login / signup");
			login.email.sendKeys(emailId);
			login.password.sendKeys(password);
			login.login.click();
			logger.info("Clicked on login");
			dashboard.bookings.click();
			logger.info("Clicked on edit profile");
			
			Assert.assertTrue(home.airlines.isDisplayed());
		    logger.info("Verified booking");
			
		}

	}

}
