Feature: Edit Attendance

  Scenario: Validate admin able to update  attendance data
    Given Admin is in manage attendance page
    When Admin clicks edit icon and update the attendance values in the attendance popup window
    Then Admin should see success message in popup window and sees updated attendance details in manage attendance DB

  Scenario: Validate admin able to update attendance data without program name
    Given Admin is in manage attendance page
    When Admin clicks edit icon and update the attendance values with missing program name
    Then Admin should receive warn message to fill all the fields

  Scenario: Validate admin able to update attendance data without class name
    Given Admin is in manage attendance page
    When Admin clicks edit icon and update the attendance values with missing class name
    Then Admin should receive warn message to fill all the fields

  Scenario: Validate admin able to update attendance data without student name
    Given Admin is in manage attendance page
    When Admin clicks edit icon and update the attendance values with missing student name
    Then Admin should receive warn message to fill all the fields

  Scenario: Validate admin able to update attendance data without attendances
    Given Admin is in manage attendance page
    When Admin clicks edit icon and update the attendance values with missing attendance
    Then Admin should receive warn message to fill all the fields

  Scenario: Validate admin able to update attendance data without attendance date
    Given Admin is in manage attendance page
    When Admin clicks edit icon and update the attendance values with missing attendance date
    Then Admin should receive warn message to fill all the fields

