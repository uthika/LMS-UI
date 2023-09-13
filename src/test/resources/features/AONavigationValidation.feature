Feature: Navigation Validation from Manage Program to other Pages

  Scenario:Student link on navigation bar
    Given  Admin is on Manage Program page
    When Admin clicks on Student link on Manage Program page
    Then Admin is re-directed to Student page

  Scenario:
    Given Admin is on Manage Program page
    When Admin clicks on Batch link on Manage Program page
    Then Admin is re-directed to Batch page

  Scenario:
    Given Admin is on Manage Program page
    When Admin clicks on Class link on Manage Program page
    Then Admin is re-directed to Class page

  Scenario:
    Given Admin is on Manage Program page
    When Admin clicks on User link on Manage Program page
    Then Admin is re-directed to User page

  Scenario:
    Given Admin is on Manage Program page
    When Admin clicks on Assignment link on Manage Program page
    Then Admin is re-directed to Assignment page

  Scenario:
    Given Admin is on Manage Program page
    When Admin clicks on Attendance link on Manage Program page
    Then Admin is re-directed to Attendance page

    Scenario:Logout link on navigation bar
      Given Admin clicks on Logout link on Manage Program page
      When Admin clicks on Logout link on Manage Program page
      Then Admin is re-directed to Login page
