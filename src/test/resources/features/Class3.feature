Feature: Add New Class

  Scenario: Validate all batch id is reflecting in the dropdown
    Given Admin is in  class detail popup window
    When Admin clicks  Batch ID dropdown
    Then Batch id in the drop down should match with Batch id manage batch page table

  Scenario Outline: Validate admin able to add new class with valid data in mandatory fields
    When Admin enters all mandatory field "<sheetName>" with valid <rowNumber> and clicks save button
    Then Admin should see new class details is added in the data table
    And clicks save button
    Then Admin should see success message "new class details is added"

    Examples: 
      | sheetName         | rowNumber |
      | addClassvalidData |         0 |
      | addClassvalidData |         1 |
      | addClassvalidData |         2 |

  Scenario Outline: Validate admin able to add new class with invalid data  in optional fields
    When Admin enters with invalid "<sheetName>" data <rowNumber> and clicks save button
    Then Error message should appear in alert

    Examples: 
      | sheetName           | rowNumber |
      | addClassInvalidData |         0 |
      | addClassInvalidData |         1 |

  Scenario Outline: Validate admin able to update class missing staff id
    When Admin enters data missing value in "<sheetName>" <rowNumber> and clicks save button
    Then Error message displays is missing

    Examples: 
      | sheetName   | rowNumber |
      | missingData |         0 |
      | missingData |         1 |
      | missingData |         2 |
      | missingData |         3 |
      | missingData |         4 |

  Scenario: Validate date picker
    When Admin clicks date from date picker
    Then selected date should be their in class date text box

  Scenario: validate date picker should be correct format
    When Admin clicks date from date picker
    Then selected date should be in  mm/dd/yyyy format

  Scenario: Validate right arrow in data picker to navigate to next month
    When Admin clicks right arrow in the date picker near month
    Then Next month calender should visible

  Scenario: Validate left arrow in data picker to navigate to previous month
    When Admin clicks left arrow in the date picker near month
    Then previous month calender should visible

  Scenario: Validate current date is highlighted in the date picker
    When Admin clicks date picker button
    Then Admin should see current date is highled in the date picker

  Scenario: Validate selected date is highlighted in the date picker
    When Admin clicks date picker button and selects future date
    Then Admin should see selected date is highled in the date picker
