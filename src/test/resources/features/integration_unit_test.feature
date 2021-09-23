@API
Feature: Integration and Unit Tests

	Scenario: Add a new place
		Given A new "place" is added from backend
		When Checked in UI
		Then The added "place" should reflect on the UI

	Scenario: Add a new Flight
		Given A new "airline" is added from backend
		And A new "flight" is added from backend
		When Checked in UI
		Then The added "flight" should reflect on the UI
		
	Scenario: Add a new user
		Given A new "user" is added from backend
		When Checked in UI
		Then The added "user" should reflect on the UI

	Scenario: Add a new booking for above user
		Given A new "booking" is added from backend
		When Checked in UI
		Then The added "booking" should reflect on the UI
		