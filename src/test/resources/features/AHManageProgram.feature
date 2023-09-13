Feature: Manage Program Validation
Scenario: Validate landing in Program page
Given Admin is on dashboard page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see URL with "Manage Program"

Scenario: Validate the heading
Given Admin is on dashboard page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see a heading with text "Manage Program" on the page

Scenario: Validate the text and pagination icon below the data table
Given Admin is on dashboard page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table.
#

Scenario: Validate the footer
Given Admin is on dashboard page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see the footer as "In total there are z programs".


Scenario: Validating the default state of Delete button
Given Admin is on dashboard page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see a Delete button on the top left hand side as Disabled

Scenario: Validate Add New Program
Given Admin is on dashboard page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see a "+A New Program" button on the program page above the data table

Scenario: Validate that number of records (rows of data in the table) displayed
Given Admin is on dashboard page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should see the number of records (rows of data in the table) displayed on the page are 5

  Scenario:Verify data table on the Program page
  Given Admin is on dashboard page after Login
  When Admin clicks "Program" on the navigation bar
  Then Admin should see data table on the Manage Program Page with following column headers (Program Name, Program Description, Program Status, Edit,Delete)

  Scenario:Verify Sort arrow icon on the data table
  Given Admin is on dashboard page after Login
  When Admin clicks "Program" on the navigation bar
  Then Admin should see the sort arrow icon beside to each column header except Edit and Delete

  Scenario:Verify Check box on the data table
  Given Admin is on dashboard page after Login
  When Admin clicks "Program" on the navigation bar
  Then Admin should see check box on the left side in all rows of the data table

  Scenario:Verify Edit and Delete buttons
  Given Admin is on dashboard page after Login
  When Admin clicks "Program" on the navigation bar
  Then Admin should see the Edit and Delete buttons on each row of the data table

  Scenario:Verify Search bar on the Program page
  Given Admin clicks "Program" on the navigation bar
  When Admin clicks "Program" on the navigation bar
  Then Admin should see Search bar with text as "Search..."

 Scenario: Search Program By Name
 Given Admin is on Manage Program Page
 When Admin enters <Program name phrase> into search box.
 Then Admin should see the Programs displayed based on the Program Name

  Scenario: Search Program By Description
 Given Admin is on Manage Program Page
 When Admin enters <Program description phrase> into search box.
 Then Admin should see the Programs displayed based on the Program Description

 Scenario: Search Program By Status
 Given Admin is on Manage Program Page
 When Admin enters <Program status phrase> into search box.
 Then Admin should see the Programs displayed based on the Program Status

  Scenario: Validating the Search with unrelated keyword
 Given Admin is on Manage Program Page
 When Admin enters the keywords not present in the data table on the Search box
 Then Admin should see zero entries on the data table