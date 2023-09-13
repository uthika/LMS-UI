Feature: Delete user
  Scenario:Validate row level delete icon
    Given The delete icon on row level in data table is enabled
    When Admin clicks the delete icon
    Then Alert appears with yes and No option

  Scenario:Validate accept alert
    Given Admin clicks the delete icon
    When Admin click yes option
    Then User deleted alert pops and user is no more available in data table

  Scenario:Validate reject alert
    Given Admin clicks the delete icon
    When Admin click No option
    Then User is still listed in data table

  Scenario:Validate the delete icon below the header
    Given None of the checkboxes in data table are selected
    Then The delete icon under the "Manage User" header should be disabled

  Scenario:Check for single row delete
    Given One of the checkbox/ row is selected
    When Click delete icon below "Manage User" header
    Then The respective row in the data table is deleted

  Scenario:Check for multi row delete
    Given Two or more checkboxes/row is selected
    When Click delete icon below "Manage User" header
    Then The respective row in the data table is deleted