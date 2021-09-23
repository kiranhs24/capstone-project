@UI
Feature: UI Tests

	Scenario: Check sign up fields
		Given User opens the site
		When User clicks on signup
		Then User should be able to see signup fields
		
	Scenario: Check for existing email error
		Given User opens the site
		When User clicks on signup
		And User uses an existing email to signup
		Then User should be able to see email error

	Scenario: Check for missing mandatory field error
		Given User opens the site
		When User clicks on signup
		And User forgets to enter mandatory field
		Then User should be able to see mandatory field error

	Scenario: Check for airlines available
		Given User opens the site
		When User clicks on home page
		Then User should be able to see list of airline available

	Scenario: Check specific airline
		Given User opens the site
		When User clicks on home page
		And Chooses a source and destination
		Then User should be able to see list of airline available

	Scenario: Check for login error
		Given User opens the site
		When User clicks on home page
		And Chooses a source and destination
		And Clicks on book flight
		Then User should be able to see login error

	Scenario: Sign up as a new user
		Given User opens the site
		When User clicks on signup
		And User enters all the details and clicks on signup
		Then User should be signed up as new member

	Scenario: Login as exisitng user
		Given User opens the site
		When User clicks on login button
		And User enters required details and click on login
		Then User should land on dashboard
		
	Scenario: Edit Profile Fields
		Given User opens the site
		When User clicks on login button
		And User enters required details and click on login
		And User clicks on edit profile
		Then User should land of edit profile page

	Scenario: Update Profile
		Given User opens the site
		When User clicks on login button		
		And User enters required details and click on login
		And User clicks on edit profile
		And User updates a field
		Then Update should be saved
		
	Scenario: Update Password
		Given User opens the site
		When User clicks on login button		
		And User enters required details and click on login
		And User clicks on edit profile
		And User updates password
		Then Password should be updated 

	Scenario: Check bookings page on new sign up
		Given User opens the site
		When User clicks on login button		
		And User enters required details and click on login
		And User clicks on your bookings
		Then User should see an empty page

	Scenario: Verify booking of airline
		Given User opens the site
		When User clicks on login button		
		And User enters required details and click on login
		When User clicks on home page
		And Chooses a source and destination
		And Clicks on book flight
		And Completes the purchase
		Then Flight must be booked 
		And Booking should reflect on your bookings page

	Scenario: Logout
		Given User opens the site
		When User clicks on login button		
		And User enters required details and click on login
		And User clicks on home page
		And User clicks on logout
		Then User should be logged out of the app

		