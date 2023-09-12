Feature: Login Page Verification

  Background:
    Given Admin gives the correct LMS portal URL
    
@TC001
  Scenario: Verify the login page
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should land on the login page
@TC002
  Scenario: Verify for broken link
    Given Admin is in home page
    When Admin clicks Login button
    Then HTTP response >= 400. Then the link is broken
@TC003
  Scenario: Verify the header of the login page
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see "Please login to LMS application" in the header
@TC004
  Scenario: Verify the text spelling in the login page
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see correct spellings in all fields
@TC005
  Scenario: Verify text field is present
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see two text fields
@TC006
  Scenario: Verify text on the first text field
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see "user" in the first text field
@TC007
  Scenario: Verify asterisk next to user text
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see * symbol next to user text
@TC008
  Scenario: Verify text on the second text field
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see "password" in the second text field
@TC009
  Scenario: Verify asterisk next to password text
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see * symbol next to password text
@TC010
  Scenario: Verify the alignment input field for the login
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see input field in the center of the page
@TC011
  Scenario: Verify Login is present
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see login button
@TC012
  Scenario: Verify the alignment of the login button
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see login button in the center of the page
@TC013
  Scenario: Verify forgot username or password link
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see forgot username or password link
@TC014
  Scenario: Verify for the Reset password link
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see reset password link
@TC015
  Scenario: Verify input descriptive text in user field
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see user in gray color
@TC016
  Scenario: Verify input descriptive text in password field
    Given Admin is in home page
    When Admin clicks Login button
    Then Admin should see password in gray color
@TC017
  Scenario: Validate login with valid credentials
    Given Admin in login page after clicking login button in home page
    When Admin enter valid credentials and clicks login button
    Then Admin should land on the dashboard page
 @TC018 
  Scenario: Validate login with invalid credentials
    Given Admin is in login page
    When Admin enter invalid credentials and clicks login button
    Then Error message "Please check username/password" should be displayed
  @TC019 
  Scenario: Validate login with valid credentials in username
    Given Admin is in login page
    When Admin enter valid username and clicks login button
    Then Error message "Please check password" should be displayed
@TC020
  Scenario: Validate login with valid credentials in password
    Given Admin is in login page
    When Admin enter valid password and clicks login button
    Then Error message "Please check username" should be displayed
@TC021
  Scenario: Validate login with blank username credentials
    Given Admin is in login page
    When Admin enter blank in username and clicks login button
    Then Error message "Please check username/password" should be displayed
@TC022
  Scenario: Validate login with blank password credentials
    Given Admin is in login page
    When Admin enter blank in password and clicks login button
    Then Error message "Please check username/password" should be displayed
@TC023
  Scenario: Validate login with empty values in both fields
    Given Admin is in login page
    When Admin clicks Login button with empty values in both columns
    Then Error message "Please check username/password" should be displayed
@TC024
  Scenario: Verify login button action through keyboard
    Given Admin is in login page
    When Admin enter valid credentials and clicks login button through keyboard
    Then Admin should land on the dashboard page
@TC025
  Scenario: Verify login button action through mouse
    Given Admin is in login page
    When Admin enter valid credentials and clicks login button through mouse
    Then Admin should land on the dashboard page