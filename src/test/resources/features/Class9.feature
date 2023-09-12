Feature: Navigation function validation from manage class page to other pages

  Scenario Outline: Verify admin is able to navigate from manage class to other pages
    Given Admin is in Manage class page
    When Admin clicks "<pages>" button in the navigation bar
    Then Admin should able to land on "<pages>" page

    Examples: 
      | pages       | 
      | Student     |
      | Program     | 
      | Batch       | 
      | User        | 
      | Assignment  | 
      | Attendance  | 