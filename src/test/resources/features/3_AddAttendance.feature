Feature: Add New Attendance

Scenario Outline:  Validate admin able to create new attendance data with all mandatory fields
  Given Admin is in  attendance details popup window
  When Admin fills all the values from given sheetname "<SheetName>" and rownumber <RowNumber> and click save
  Then Admin should see success message in popup window and sees new attendance details in manage attendance details DB
  Examples:
    |SheetName|RowNumber|
    | add    |   0     |
    | add    |   1     |

    Scenario Outline: Validate admin able to create new attendance data with missing some mandatory fields
      Given Admin is in  attendance details popup window
      When Admin fills all the values from given sheetname "<SheetName>" and rownumber <RowNumber> and click save
      Then Admin should get a message "Please fill out all fields with valid data"
      Examples:
        |SheetName|RowNumber|
        | add     |   2     |
        | add     |   3     |
        | add     |   4     |
        | add     |   5     |
        | add     |   6     |
        | add     |   7     |