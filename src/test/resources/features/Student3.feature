@tag
Feature: Navigation Validation from student page to other Pages

  @tag1
  Scenario: Program link on navigation bar
    Given Assignment link on navigation bar
    When Admin clicks on program link on student  page
    Then Admin is redirected to Program page

  @tag1
  Scenario: Batch link on navigation bar
    Given Assignment link on navigation bar
    When Admin clicks on Batch link on student page
    Then Admin is redirected to Batch page

  @tag1
  Scenario: Class link on navigation bar
    Given Assignment link on navigation bar
    When Admin clicks on Batch link on student page
    Then Admin is redirected to User page

  @tag1
  Scenario: User link on navigation bar
    Given Assignment link on navigation bar
    When Admin clicks on User link on student page
    Then Admin is redirected to Assignment page

  @tag1
  Scenario: Assignment link on navigation bar
    Given Assignment link on navigation bar
    When Admin clicks on Assignment link on student page
    Then Admin is redirected to Batch page

  @tag1
  Scenario: Attendance link on navigation bar
    Given Assignment link on navigation bar
    When Admin clicks on Attendance link on student page
    Then Admin is redirected to Batch page

  @tag1
  Scenario: Logout link on navigation bar
    Given Assignment link on navigation bar
    When Admin clicks on Logout link on student page
    Then Admin is redirected to Batch page
