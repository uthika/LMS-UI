Feature: Assignment details Popup window verification

  @TC001
Scenario: Verify Assignment details popup window
  Given Admin is on manage assignment Page
  When Admin click +Add new assignment button
  Then Admin should see a popup  with  heading "Assignment details"

  @TC002
  Scenario: Verify input fields in Assignment details popup window
    Given Admin is on manage assignment Page
    When Admin click +Add new assignment button
    Then Admin should see input fields Text
#  (Program name, batch number,Assignment Name, Assignment Description, grade by, Assignment due date, Assignment File1, Assignment file 2, Assignment file 3, Assignment file 4, Assignment file 5)

  @TC003
  Scenario: Verify text box present in Assignment details popup window
    Given Admin is on manage assignment Page
    When Admin click +Add new assignment button
    Then 8 textbox should be  present in Assignment details popup window

  @TC004
  Scenario: Verify drop down in Batch Number  in Assignment details popup window
    Given Admin is on manage assignment Page
    When Admin click +Add new assignment button
    Then Admin should see  dropdown option for Batch Number

  @TC005
  Scenario: Verify drop down in Program name  in Assignment details popup window
    Given Admin is on manage assignment Page
    When Admin click +Add new assignment button
    Then Admin should see  dropdown option for Program name

  @TC006
  Scenario: Verify calendar icon in Assignment due date  in Assignment details popup window
    Given Admin is on manage assignment Page
    When Admin click +Add new assignment button
    Then Admin should see  calendar icon for assignment due date

  @TC007
  Scenario: Verify save button is present
    Given Admin is on manage assignment Page
    When Admin click +Add new assignment button
    Then Admin should see  save button in the Assignment detail popup window

  @TC008
  Scenario: Verify cancel button is present
    Given Admin is on manage assignment Page
    When Admin click +Add new assignment button
    Then Admin should see  cancel button in the Assignment detail popup window

  @TC009
  Scenario: Verify close button in  Assignment details popup window
    Given Admin is on manage assignment Page
    When Admin click +Add new assignment button
    Then Admin should see  close button on the Assignment details popup window








