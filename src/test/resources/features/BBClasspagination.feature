Feature: Pagination in manage class

  Scenario: Verify sheet one is displayed on default in data table
    When Admin clicks "Class" button on the navigation bar
    Then Data table should display 1 page  when entries available

  Scenario: Verify  right arrow is enable when sheet one is displayed in data table
    When Admin clicks "Class" button on the navigation bar
    Then Right arrow should be enabled in page one  when entries are more than 5 available

  Scenario: Verify  left arrow is disable when sheet one is displayed in data table
    When Admin clicks "Class" button on the navigation bar
    Then Left arrow should be disabled in page one  when entries are more than 5 available

  Scenario: Verify  right arrow is enable when sheet two is displayed in data table when entries are more than 10
    When Admin clicks "Class" button on the navigation bar
    Then Right arrow should be enabled in page two when entries are more than 10 available

  Scenario: Verify  left arrow is enable when sheet two is displayed in data table
    When Admin clicks "Class" button on the navigation bar
    Then Left arrow should be enabled in page two

  Scenario: Verify  right arrow is disable when sheet two is displayed in data table when entries are less than 10
    When Admin clicks "Class" button on the navigation bar
    Then Data table should display  page 1  when entries available

  Scenario: Verify pagination controls enabled
    When Admin clicks "Class" button on the navigation bar
    Then when entries are more than 5 in data table pagination controls enabled

  Scenario: Verify pagination controls disabled
    When Admin clicks "Class" button on the navigation bar
    Then when entries are less than 5 in data table pagination controls disabled

  Scenario: Verify next page is enabled
    When Admin creates 6 new class
    Then when total class entries above 5 next page is enabled

  Scenario: verify next page is disabled
    When Admin creates less than or equal to 5 new class
    Then when total class entries  5 or below next page is disabled
