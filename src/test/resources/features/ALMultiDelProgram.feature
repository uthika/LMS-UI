Feature: Multiple Delete Program
  Scenario:Validate Common Delete button enabled after clicking on any checkbox
  Given Admin is on Confirm Deletion alert
  When Admin clicks any checkbox in the data table
  Then Admin should see common delete option enabled under header Manage Program


  Scenario:Validate multiple program deletion by selecting Single checkbox
  Given Admin is on Confirm Deletion alert
    When Admin clicks <YES> button on the alert
  And Admin clicks <NO> button on the alert
  Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table

  Scenario:Validate multiple program deletion by selecting multiple check boxes
    Given Admin is on Confirm Deletion alert
    When Admin clicks <YES> button on the alert
    And Admin clicks <NO> button on the alert
    Then Admin should land on Manage Program page and can see the selected program is deleted from the data table
