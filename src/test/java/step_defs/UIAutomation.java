package step_defs;

import java.util.UUID;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BaseClass;

public class UIAutomation extends BaseClass {
	
	protected static final Logger logger = LogManager.getLogger(UIAutomation.class.getName());
	
	@Given("^User opens the site$")
	public void user_opens_the_site() throws Throwable {
	    
		logger.info("======== " + scenarioName + " ========");
		logger.info("Opened website");
		
	}

	@When("^User clicks on signup$")
	public void user_clicks_on_signup() throws Throwable {
	    
		home.loginSignup.click();
		logger.info("Landed on login page");
		login.signUp.click();
		logger.info("Landed on signu up page");
		
	}

	@Then("^User should be able to see signup fields$")
	public void user_should_be_able_to_see_signup_fields() throws Throwable {
	    
		Assert.assertTrue(login.email.isDisplayed());
		Assert.assertTrue(login.password.isDisplayed());
		Assert.assertTrue(signUp.confirmPassword.isDisplayed());
		Assert.assertTrue(signUp.name.isDisplayed());
		Assert.assertTrue(signUp.address.isDisplayed());
		Assert.assertTrue(signUp.city.isDisplayed());
		logger.info("Verified sign up fields");
		
	}

	@When("^User uses an existing email to signup$")
	public void user_uses_an_existing_email_to_signup() throws Throwable {
	    
		login.email.sendKeys("kiran@kiran.com");
		logger.info("Entered email id - kiran@kiran.com");
		login.password.sendKeys("kiran1");
		logger.info("Entered password - kiran");
		signUp.confirmPassword.sendKeys("kiran1");
		logger.info("Entered confirm password - kiran");
		signUp.name.sendKeys("Kiran");
		logger.info("Entered name - Kiran");
		signUp.signUp.click();
		logger.info("Clicked on sign up");
		
	}

	@Then("^User should be able to see email error$")
	public void user_should_be_able_to_see_email_error() throws Throwable {
	    
		Assert.assertTrue(signUp.error.getText().contains("already exists"));
		logger.info("Verified email error");
		
	}

	@When("^User forgets to enter mandatory field$")
	public void user_uses_misses_a_mandatory_field() throws Throwable {
	    
		logger.info("Missed email id");
		login.password.sendKeys("kiran1");
		logger.info("Entered password - kiran");
		signUp.confirmPassword.sendKeys("kiran1");
		logger.info("Entered confirm password - kiran");
		signUp.name.sendKeys("Kiran");
		logger.info("Entered name - Kiran");
		signUp.signUp.click();
		logger.info("Clicked on sign up");
		
	}

	@Then("^User should be able to see mandatory field error$")
	public void user_should_be_able_to_see_mandatory_field_error() throws Throwable {
	    
		Assert.assertTrue(signUp.error.getText().contains("is required"));
		logger.info("Verified mandatory error");
		
	}

	@When("^User clicks on home page$")
	public void user_clicks_on_home_page() throws Throwable {
	    
		dashboard.home.click();
		logger.info("Clicked on home");
		
	}

	@Then("^User should be able to see list of airline available$")
	public void user_should_be_able_to_see_list_of_airline_available() throws Throwable {

		Assert.assertTrue(home.airlines.isDisplayed());
		logger.info("Verfied available airlines");

	}

	@When("^Chooses a source and destination$")
	public void chooses_a_source_and_destination() throws Throwable {
		
		Select source = new Select(home.source);
		source.selectByVisibleText("Bangalore");
		logger.info("Selected Bangalore as source destination");
		
		Select destination = new Select(home.destination);
		destination.selectByVisibleText("Chennai");
		logger.info("Selected Chennai as source destination");
		
		home.submit.click();
		logger.info("Clicked on submit");
		
	}

	@When("^Clicks on book flight$")
	public void clicks_on_book_flight() throws Throwable {
		
		home.flights.get(0).click();
		logger.info("Clicked on book flight at 0 position");
		
	}

	@Then("^User should be able to see login error$")
	public void user_should_be_able_to_see_login_error() throws Throwable {
		
		Assert.assertTrue(signUp.error.getText().contains("login before booking"));
		logger.info("Verfied login error");
		
	}

	@When("^User enters all the details and clicks on signup$")
	public void user_enters_all_the_details_and_clicks_on_signup() throws Throwable {
		
		email = "kiran" + UUID.randomUUID().toString().replace("-", "") + "@kiran.com";
		password = "kiran1";
		
		login.email.sendKeys(email);
		logger.info("Entered email id - " + email);
		login.password.sendKeys(password);
		logger.info("Entered password - " + password);
		signUp.confirmPassword.sendKeys(password);
		logger.info("Entered confirm password - " + password);
		signUp.name.sendKeys("Kiran");
		logger.info("Entered name - Kiran");
		signUp.signUp.click();
		logger.info("Clicked on sign up");
		home.loginSignup.click();
		login.email.sendKeys(email);
		logger.info("Logging in with email - " + email);
		login.password.sendKeys(password);
		logger.info("Logging in with password - " + password);
		login.login.click();
		logger.info("Clicked on login");
		
	}

	@Then("^User should be signed up as new member$")
	public void user_should_be_signed_up_as_new_member() throws Throwable {
		
		Assert.assertTrue(dashboard.editProfile.isDisplayed());
		logger.info("Verified successful sign up");
		
	}

	@When("^User clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		
		home.loginSignup.click();
		logger.info("Clicked on login");
		
	}

	@When("^User enters required details and click on login$")
	public void user_enters_required_details_and_click_on_login() throws Throwable {
		
		login.email.sendKeys(email);
		logger.info("Entered email id for login - " + email);
		login.password.sendKeys(password);
		logger.info("Entered password for login - " + password);
		login.login.click();
		logger.info("Clicked on login");
		dashboard.home.click();
		
	}

	@Then("^User should land on dashboard$")
	public void user_should_land_on_home_page() throws Throwable {
		
		Assert.assertTrue(dashboard.dashboard.isDisplayed());
		logger.info("Landed on dashboard");
		
	}

	@When("^User clicks on edit profile$")
	public void user_clicks_on_edit_profile() throws Throwable {
		
		dashboard.editProfile.click();
		logger.info("Clicked on edit profile");
		
	}

	@Then("^User should land of edit profile page$")
	public void user_should_land_of_edit_profile_page() throws Throwable {
		
		Assert.assertTrue(login.password.isDisplayed());
		Assert.assertTrue(signUp.confirmPassword.isDisplayed());
		Assert.assertTrue(signUp.name.isDisplayed());
		Assert.assertTrue(signUp.address.isDisplayed());
		Assert.assertTrue(signUp.city.isDisplayed());
		logger.info("Verified edit profile fields");
		
	}

	@When("^User updates a field$")
	public void user_updates_a_field() throws Throwable {
		
		login.password.sendKeys(password);
		logger.info("Entered password - " + password);
		signUp.confirmPassword.sendKeys(password);
		logger.info("Entered confirm password - " + password);
		signUp.name.sendKeys("Kiran");
		logger.info("Entered name - Kiran");
		signUp.address.sendKeys("This is a test address");
		logger.info("Editing address field");
		signUp.update.click();
		logger.info("Updating the details");
		dashboard.editProfile.click();
		logger.info("Navigating back to edit profile page");
		
	}

	@Then("^Update should be saved$")
	public void update_should_be_saved() throws Throwable {
	   
		Assert.assertTrue(signUp.address.getAttribute("value").contains("This is a test address"));
		
	}

	@When("^User updates password$")
	public void user_updates_password() throws Throwable {
	    
		password = "kiran12";
		
		login.password.sendKeys(password);
		logger.info("Entered password - " + password);
		signUp.confirmPassword.sendKeys(password);
		logger.info("Entered confirm password - " + password);
		signUp.name.sendKeys("Kiran");
		logger.info("Entered name - Kiran");
		signUp.update.click();
		logger.info("Updating password");
		dashboard.logout.click();
		logger.info("Logging out of application to check password change");
		home.loginSignup.click();
		logger.info("Clicked on login / signup button");
		login.email.sendKeys(email);
		logger.info("Entered email id - " + email);
		login.password.sendKeys(password);
		logger.info("Entered password - " + password);
		login.login.click();
		logger.info("Clicked on login");
		
	}

	@Then("^Password should be updated$")
	public void password_should_be_updated() throws Throwable {
		
		Assert.assertTrue(dashboard.editProfile.isDisplayed());
		logger.info("Password change successful");
	    
	}

	@When("^User clicks on your bookings$")
	public void user_clicks_on_your_bookings() throws Throwable {
		
		dashboard.bookings.click();
		logger.info("Clicked on your bookings");
	   
	}

	@Then("^User should see an empty page$")
	public void user_should_see_an_empty_page() throws Throwable {
		
		Assert.assertTrue(home.airlines.isDisplayed());
	    logger.info("Your bookings is empty");
		
	}
	
	@When("^Completes the purchase$")
	public void complete_purchase() {
		
		dashboard.completePurchase.click();
		logger.info("Clicked on complete booking");
		
	}

	@Then("^Flight must be booked$")
	public void flight_must_be_booked() throws Throwable {
		
		Assert.assertTrue(dashboard.bookingConfirmation.isDisplayed());
	    logger.info("Flight booked");
	    
	}

	@Then("^Booking should reflect on your bookings page$")
	public void booking_should_reflect_on_your_bookings_page() throws Throwable {
	    
		dashboard.bookings.click();
		logger.info("Navigating to booking page");
		Assert.assertTrue(home.airlines.isDisplayed());
	    logger.info("Verified booking");
		
	}

	@When("^User clicks on logout$")
	public void user_clicks_on_logout() throws Throwable {
	   
		dashboard.logout.click();
		logger.info("Clicked on logout");
		
	}

	@Then("^User should be logged out of the app$")
	public void user_should_be_logged_out_of_the_app() throws Throwable {
		
		Assert.assertTrue(home.loginSignup.isDisplayed());
		logger.info("Successfully logged out");
		
	}

}
