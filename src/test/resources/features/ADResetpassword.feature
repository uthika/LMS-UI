Feature: Reset Password

  Background: 
    Given Admin is in login page after clicking login button in home page

  Scenario: Verify reset password link
    When Admin clicks reset password link here
    Then Admin should land on reset password page here

  Scenario: Verify text in the page
    When Admin clicks reset password link here
    Then Admin should see correct spellings in all fields here

  Scenario: Verify submit button is present
    When Admin clicks reset password link here
    Then Admin should see "submit" button here

  Scenario: Verify the alignment of the submit button
    When Admin clicks reset password link here
    Then Admin should see submit button in center of the page here

  Scenario: Verify text box is present on the page
    When Admin clicks reset password link here
    Then Admin should see two text boxes here

  Scenario: Verify first label text
    When Admin clicks reset password link here
    Then Admin should see "Type in new password" in the first label text here

  Scenario: Verify second label text
    When Admin clicks reset password link here
    Then Admin should see "Retype password" in the second label text here

  Scenario: Verify text box is in disabled
    When Admin clicks reset password link here
    Then Admin should see text box in disabled state here

  Scenario: Verify text box is in enabled in new password field
    Given Admin clicks reset password link after reaching in login page
    When Admin is navigated reset password page
    And Admin clicks on "Type in new password" field here
    Then Admin should see text box is enabled state here

  Scenario: Verify text box is in enabled in retype password field
    Given Admin is in reset password page
    When Admin clicks on "Retype password" next field here
    Then Admin should see text box is enabled state here

  Scenario: Validate reset password with valid details
    Given Admin is in reset password page
    When Admin enters the same password on both fields and clicks submit button here
    Then Admin should receive: "Your password has been reset. Please click here to login" here

  Scenario: Validate reset password with invalid details
    Given Admin is in reset password page
    When Admin enters the same password on both fields with invalid details and clicks submit button here
    Then Admin should see an error message: "Please try again" here

  Scenario: Validate reset password with empty details
    Given Admin is in reset password page
    When Admin enters empty details on both fields and clicks submit button here
    Then Admin should see an error message: "Please try again" here

  Scenario: Validate reset password mismatch values
    Given Admin is in reset password page
    When Admin enters mismatch values and clicks submit button here
    Then Admin should see an error message: "Please try again" here
