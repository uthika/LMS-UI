Feature: Home Page Verification
@TC001
  Scenario: Verify admin can land on the home page
    Given Admin launches the browser
    When Admin navigates to the correct LMS portal URL
    Then Admin should land on the home page
@TC002
  Scenario: Verify admin receives a 404 error for an invalid URL
    Given Admin launches the browser
    When Admin navigates to an invalid LMS portal URL
    Then Admin should receive a 404 Page Not Found error
@TC003
  Scenario: Verify broken links on the page
    Given Admin launches the browser
    When Admin navigates to the correct LMS portal URL
    Then HTTP response code should be greater than or equal to 400 indicating broken links
@TC004
  Scenario: Verify correct spellings on the page
    Given Admin launches the browser
    When Admin navigates to the correct LMS portal URL
    Then Admin should see correct spellings in all fields
@TC005
  Scenario: Verify the LMS logo is displayed
    Given Admin launches the browser
    When Admin navigates to the correct LMS portal URL
    Then Admin should see the correct logo of the LMS
@TC006
  Scenario: Verify the alignment of the LMS logo
    Given Admin launches the browser
    When Admin navigates to the correct LMS portal URL
    Then Admin should see that the logo is properly aligned
@TC007
  Scenario: Verify the presence of the login button
    Given Admin launches the browser
    When Admin navigates to the correct LMS portal URL
    Then Admin should see the login button
@TC008
  Scenario: Verify the login button is clickable
    Given Admin launches the browser
    When Admin navigates to the correct LMS portal URL
    Then Admin should be able to click the Login button