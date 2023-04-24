@addcustomer
Feature: New customer login feature

Scenario: verify that user can able to fill form in New customer field
			Given verify that user navigate to right applictaion
			And user enter the userid as "mngr486474"
			And user enter the password as "bemajat"
			Then user clicks the login button
			And verify that user landed in right page
			And user clicks new customer field
			Then verify that user can able to fill customer name
			And user click the gender radio button
			And verify that user can fill the date of birth 
			Then user fill the address field 
			And user fill the city and state 
			And user fill the pin number		
			Then user fill the telephone number 
			And user the fill the email address 
			#And user finally clicks the submit button