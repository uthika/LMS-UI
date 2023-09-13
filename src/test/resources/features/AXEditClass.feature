Feature: Edit class Validation

  Scenario: Verify Edit class popup window
    When Admin clicks Edit button in data table
    Then Edit popup window appears with heading Class Details

  Scenario: Verify values in popup window
    When Admin clicks Edit button from one of the row in data table
    Then Edit popup window appears with same row values in the all fields

  Scenario: Validate admin able to  update class with valid data  in all fields
    When Admin enters values in all fields with valid data and clicks save button
    Then Admin should see particular class details is updated in the data table
