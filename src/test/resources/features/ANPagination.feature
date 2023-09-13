Feature: Pagination
Scenario: Verify Next page link
 Given Admin is on Manage Program page
  When Admin clicks Next page link on the program table
  Then Admin should see the Pagination has "Next" link

  Scenario:Verify Last page link
    Given Admin is on Manage Program page
   When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link are disabled

  Scenario:Verify First page link
    Given Admin is on last page of Program table
    When Admin clicks First page link
    Then Admin should see the previous page record on the table with pagination has previous page link

  Scenario:Verify Start page link
    Given Admin is on Previous Program page
  When Admin clicks Start page link
    Then Admin should see the very first page record on the table with Previous page link are disabled

