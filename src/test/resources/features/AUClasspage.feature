Feature: Verify landing in class page

  @MC01
  Scenario: Verify landing in class page
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Admin should see URL with "Manage Class"

  @MC02
  Scenario: Capture the response time to navigate to manage class page
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Get the response time for navigation from dashboard page to manage class page

  @MC03
  Scenario: Verify Manage Class Page Header
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Admin should see header with "Manage Class"

  @MC04
  Scenario: Validate text in manage class page
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar and get all text from the portal page
    Then Admin should see correct spelling for the all the fields

  @MC05
  Scenario: Verify delete icon below the header
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Admin should see disabled delete icon below the "Manage Class"

  @MC06
  Scenario: Verify search bar on the class page
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Admin should see search bar on the class page

  @MC07
  Scenario: Verify add new class button  on class page
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Admin should see +Add New Class button on the class page

  @MC08
  Scenario Outline: Verify data table on the class page
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Admin should see data table on the Manage Class Page With all "<column headers>"

    Examples: 
      | column headers   |
      | Check box symbol |
      | Batch Id         |
      | Class No         |
      | Class Date       |
      | Class Topic      |
      | Staff Id         |
      | Description      |
      | Comments         |
      | Notes            |
      | Recording        |
      | Edit             |
      | Delete           |

  @MC09
  Scenario: Verify Edit icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Edit Icon in each row of data table only  when entries are available

  @Mc10
  Scenario: Verify Edit icon when no data in the table
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Edit Icon will not be present in data table

  @MC11
  Scenario: Verify delete icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Delete Icon in each row of data table only  when entries are available

  @MC12
  Scenario: Verify delete icon when no data in the table
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Admin cant see delete  Icon in data table

  @MC13
  Scenario: Verify sort icon in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Admin should see sort icon near the column headers except for Edit and Delete

  Scenario: Verify check box in the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Admin should see check box in the all rows  of data table
    
 Scenario: Verify Pagination control below the data table
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Admin should see the pagination controls under the data table

  Scenario: Validate footer  text
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Admin should see the text with total number classes in the data table "number"

  Scenario: Validate search box function
    Given Admin is on dashboard page after Login
    When Admin enters batch id into search box  
    Then Displays entries with that batch Id
  
    When Admin enters class no into search box
    Then Displays entries with that class no
    
    When Admin enters batch id which is not existing the table into search box
    Then Displays empty details in the data table
    
    When Admin enters class no which is not existing the table into search box
    Then Displays empty details in the data table
    
    When Admin enters class topic into search box
    Then Displays entries with that  class topic
    
    When Admin enters class topic which is not existing the table into search box
    Then Displays empty details in the data table
    
    When Admin enters staff id into search box
    Then Displays entries with that  staff id
    
    When Admin enters staff id which is not existing the table into search box
    Then Displays empty details in the data table
    
    
