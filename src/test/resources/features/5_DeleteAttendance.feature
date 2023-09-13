Feature: Delete attendance and Delete multiple attendance validation

  Scenario: Verify Delete attendance alert
    Given Admin is in manage attendance page
    When Admin clicks delete attendance button in data table row level
    Then Admin should see attendance alert

  Scenario: Verify  accept enabled in alert
    Given Admin is in manage attendance page
    When Admin clicks delete attendance button in data table row level
    Then Alert should have "yes" button to accept attendance

  Scenario: Verify reject enabled in alert
    Given Admin is in manage attendance page
    When Admin clicks delete attendance button in data table row level
    Then Alert should have "No" button to reject attendance

  Scenario: Validate accept in alert
    Given Admin is in delete attendance alert
    When Admin clicks yes button attendance alert
    Then Success message and selected attendance details are deleted from the data table

  Scenario: Validate reject in alert
    Given Admin is in delete attendance alert
    When Admin clicks no button attendance alert
    Then Redirected attendance page and selected attendance details are not deleted from the data table

  Scenario: Verify delete multiple class  button is enabled
    Given Admin is in manage attendance page
    When Admin clicks single  row level check box in the attendance data table
    Then Admin should see attendance delete icon below the header is enabled

  Scenario: verify tick mark is visible after clicking on check box for single data
    Given Admin is in manage attendance page
    When Admin clicks single  row level check box in the attendance data table
    Then Admin should see tick mark in attendance check box

  Scenario: verify admin able to click multiple check box
    Given Admin is in manage attendance page
    When Admin clicks multiple row level attendance check box in the data table
      | Checkbox 1 |
      | Checkbox 2 |
      | Checkbox 3 |
    Then Admin should see tick mark in attendance check box  of the selected rows

  Scenario: Verify accept alert in delete multiple attendance by selecting single checkbox
    Given Admin is in delete attendance alert
    When Admin clicks yes button attendance alert
    Then Success message and selected attendance detail are deleted from the data table

  Scenario: Verify reject alert in delete multiple attendance by selecting single checkbox
    Given Admin is in delete attendance alert
    When Admin clicks no button attendance alert
    Then Redirected to attendance page and selected attendance details are not deleted from the data table

  Scenario: Verify accept alert in delete multiple attendance by selecting multiple checkbox
    Given Admin is in delete attendance alert
    When Admin clicks yes button attendance alert
    Then Success message and validate particular attendance details are deleted from the data table

  Scenario: Verify reject alert in delete multiple attendance by selecting multiple checkbox
    Given Admin is in delete attendance alert
    When Admin clicks no button attendance alert
    Then Redirected to attendance page and selected attendance details are not deleted from the data table




