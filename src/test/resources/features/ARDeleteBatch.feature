@tag
Feature: Delete multiple batches

  Background: Logged on the LMS portal
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar

  @TC0061
  Scenario: Validate row level delete icon
    Given The delete icon on row level in data table is enabled
    When Admin clicks the delete icon
    Then Alert appears with yes and No option

  @TC0062
  Scenario: Validate accept alert
    Given Admin clicks the delete icon
    When You click yes option
    Then Batch deleted alert pops and batch is no more available in data table

  @TC0063
  Scenario: Validate reject alert
    Given Admin clicks the delete icon
    When you click No option
    Then Batch is still listed in data table
