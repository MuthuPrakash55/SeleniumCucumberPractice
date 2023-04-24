@login
Feature: Login feature

  @valid
  Scenario: verify that user can able to login with valid credentials
    Given verify that user navigate to right applictaion
    And user enter the userid as "mngr486474"
    And user enter the password as "bemajat"
    Then user clicks the login button
    And verify that user landed in right page

  @invalid
  Scenario: verify that user can able to login with invalid userid
    Given verify that user navigate to right applictaion
    And user enter the invalid userid as "mnr486474"
    And user enter the password as "bemajat"
    Then user clicks the login button
    And verify that user get a alert message and accept and return to loginpage

  @withoutdata
  Scenario: verify that user can able to login without entering credentials
    Given verify that user navigate to right applictaion
    And user enter the userid as ""
    And user enter the password as ""
    Then user clicks the login button
    And user get the error userid must not be blank
    And user get the error password must not be blank
