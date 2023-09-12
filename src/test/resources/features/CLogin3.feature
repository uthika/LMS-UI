Feature: Forgot Username/Password

  Background:
    Given Admin is in login page after clicking login button in home page

  Scenario: Verify forgot username or password link
    When Admin clicks forgot username or password link
    Then Admin should land on forgot username or password page

  Scenario: Verify broken link
    When Admin clicks forgot username or password link
    Then HTTP response >= 400. Then the link is broken

  Scenario: Verify input descriptive text for Email
    When Admin clicks forgot username or password link
    Then Admin should see "Email" text in gray color

  Scenario: Verify email text in text field
    When Admin clicks forgot username or password link
    Then Admin should see "Email" in text field

  Scenario: Verify send link button is present
    When Admin clicks forgot username or password link
    Then Admin should see "send Link" button

  Scenario: Verify asterisk near Email text
    When Admin clicks forgot username or password link
    Then Admin should see asterisk symbol near Email text

  Scenario: Verify text spelling
    When Admin clicks forgot username or password link
    Then Admin should see correct spellings in all fields

  Scenario: Verify the alignment of the send link button
    When Admin clicks forgot username or password link
    Then Admin should see send link button in the center of the page

  Scenario: Validate email sent for forgot password
    Given Admin is in forgot username and password page
    When Admin enters valid email id and clicks send link button
    Then Admin should receive link in mail for reset username / password

  Scenario: Validate email sent for forgot password with invalid email
    When Admin enters invalid email id and clicks send link button
    Then Admin should not receive link in mail for reset username / password