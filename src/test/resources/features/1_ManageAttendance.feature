Feature: Manage Attendance Page verification

  #BackGround:Logged on the LMS portal as Admin

  Scenario: Validate the header of the page
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see the Manage attendance in header

  Scenario: Validate response time from dashboard page to attendance page
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then  Maximum navigation time in milliseconds, defaults to 30 seconds

  Scenario: Validate the broken link
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then HTTP response >= 400. Then the link is broken

  Scenario: Verify LMS title
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see LMS -Learning management system  as title

  Scenario: Verify the alignment of the Manage Attendance header
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Manage attendance header should be in left side of the page

  Scenario: Validate text in manage attendancepage
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" button on the navigation bar and get all text from the portal page
    Then Admin should see correct spelling for the all the attendance fields

  Scenario: Verify delete icon below the header
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see disabled delete icon below the "Manage Attendance"

  Scenario: Verify search bar on the class page
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see search bar on the attendance page

  Scenario: Verify add new Attendance button on Attendance page
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see +Add New Attendance button on the attendance page

  Scenario: Verify data table on the attendance page
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see data table on the Manage Attendance Page With following column headers
    #(Check box symbol,Class ID, Student Id,Preasent, Edit /Delete)

  Scenario: Verify Edit icon in the data table
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Edit Icon in each row of data table only  when attendance entries are available

  Scenario: Verify Edit icon when no data in the table
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Edit Icon will not be present in attendance data table

  Scenario: Verify delete icon in the data table
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Delete Icon in each row of data table only  when attendance entries are available

  Scenario: Verify delete icon when no data in the table
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin cant see delete  Icon in attendance data table

  Scenario: Verify sort icon in the data table
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see sort icon near the column headers except for attendance Edit and Delete

  Scenario: Verify check box in the data table
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see check box in the all rows  of attendance data table

  Scenario: Validate the number entries displaying
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then "Above the footer Admin should see the text as "Showing x to y of z entries" below the attendance table.

  Scenario: Verify Pagination control below the data table
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see the pagination controls under the attendance data table

  Scenario: Validate footer  text
    Given Admin user is on dashboard page after Login
    When Admin clicks "Attendance" on the navigation bar
    Then Admin should see the text with total number attendance in the data table


