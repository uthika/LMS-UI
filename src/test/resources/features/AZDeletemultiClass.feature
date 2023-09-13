Feature: Delete multiple class validation

  Scenario: Verify delete multiple class  button is enabled
    Given Admin is in Manage class page
    When Admin clicks single row level check box in the data table
    Then Admin should see delete icon below the header is enabled

  Scenario: verify admin able to click multiple check box
    Given Admin is in Manage class page
    When Admin clicks multiple row level check box in the data table
    Then Admin should see tick mark in check box  of the selected rows

  Scenario: Verify accept alert in delete multiple class function by selecting single checkbox
    Given Admin is in delete alert
    When Admin clicks yes button
    Then Success message and validate particular class details are deleted from the data table

  Scenario: Verify accept alert in delete multiple class function by selecting single checkbox
    Given Admin is in delete alert
    When Admin clicks no button
    Then Admin should land on manage class page and validate particular class details are not deleted from the data table

  Scenario: Verify accept alert in delete multiple class function by selecting multiple checkbox
    Given Admin is in delete alert
    When Admin clicks yes button
    Then Admin should land on manage class page and validate particular class details are deleted from the data table

  Scenario: Verify accept alert in delete multiple class function by selecting multiple checkbox
    Given Admin is in delete alert
    When Admin clicks no button
    Then Admin should land on manage class page and validate particular class details are not deleted from the data table
