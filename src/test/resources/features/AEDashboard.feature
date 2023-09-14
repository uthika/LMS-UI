
@TC005
Feature: Dashboard Page


	Background: Url backgroud
	Given Admin clicks Login button after giving correct URL

  @TC0051
  Scenario: Verify after login  admin lands on manage program as dashboard page
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should see manage program as header

  @TC0052
  Scenario: Verify the response time
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Maximum navigation time in milliseconds, defaults to 30 seconds

  @TC0053
  Scenario: Verify broken link
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then HTTP response >= 400. Then the link is broken

  @TC0054
  Scenario: Verify LMS title
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should see LMS -Learning management system  as title

  @TC0055
  Scenario: Verify  LMS title alignment
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then LMS title should be on the top left corner of page

  @TC0056
  Scenario: Validate navigation bar text
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should see correct spelling in navigation bar text

  @TC0057
  Scenario: Validate LMS title has correct spelling ang space
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should see correct spelling and space in LMS title

  @TC0058
  Scenario: Validate alignment for navigation bar
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should see the navigation bar text on the top right side

  @TC0059
  Scenario: Validate navigation bar order 1st Student
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should see student in the 1st place

  @TC0060
  Scenario: Validate navigation bar order  2nd Program
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should see program in the 2nd place

  @TC0061
  Scenario: Validate navigation bar order  3rd Batch
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should see batch in the 3rd place
    
    @TC0062
  Scenario: Validate navigation bar order 4th Class
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should see class in the 4th place
    
     @TC0063
  Scenario: Validate navigation bar order 5th User
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should see student in the  5th user
    
    @TC0064
  Scenario: Validate navigation bar order 6th Assignment
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should see student in the  6th assignment 
    
    
    
    @TC0065
  Scenario: Validate navigation bar order 7th Attendance
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should see student in the  7th attendance
    
    
     @TC0066
  Scenario: Validate navigation bar order 8th Logout 
    Given Admin is in login page
    When Admin enter valid credentials  and clicks login button
    Then Admin should see student in the 8th logout
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
