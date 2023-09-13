@TC005
Feature: Batch Page Validation

Background: batch
Given Logged on the LMS portal

@TC0151
  Scenario: Verify after login  admin lands on manage program as dashboard page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should see the "Manage Batch" in the URL

  @TC0152
  Scenario: Validate header in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should see the "Manage Batch" in the header

  @TC0153
  Scenario: Validate pagination in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should see the pagination controls under the data table

  @TC0154
  Scenario: Validate data table headers in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete

  @TC0155
  Scenario: Validate Delete button in Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should be able to see the "Delete" icon button that is disabled

  @TC0156
  Scenario: Validate "+ A New batch" in Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should be able to see the "+ A New batch" button

  @TC0157
  Scenario: Validate data rows
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Each row in the data table should have a checkbox

  @TC0158
  Scenario: Validate data rows
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Each row in the data table should have a edit icon that is enabled

  @TC0159
  Scenario: Validate data rows
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Each row in the data table should have a delete icon that is enabled

  @TC0160
  Scenario: Validate pop up for adding batch
    Given Admin is on dashboard page after Login
    When Admin clicks "+ A New Batch" button
    Then A new pop up with Batch details appears
