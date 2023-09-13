@tag
Feature: Delete multiple batches

  Background: Logged on the LMS portal
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar

  @TC0071
  Scenario: Validate the delete icon below the header
    Given None of the checkboxes in data table are selected
    Then The delete icon under the "Manage Batch" header should be disabled

  @TC0072
  Scenario: Check for single row delete
    Given One of the checkbox row is selected
    When Click delete icon below "Manage Batch" header
    Then The respective row in the data table is deleted

  @TC0073
  Scenario: Check for multi row delete
    Given Two or more checkboxes row is selected
    When Click delete icon below "Manage Batch" header
    Then The respective row in the data table is deleted
