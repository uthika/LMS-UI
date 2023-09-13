Feature: Navigation function validation from manage attendance page to other pages

  Scenario Outline: Verify admin is able to navigate from manage attendance to other pages
    Given Admin is in manage attendance page
    When Admin clicks " <option>" button in the attendance navigation bar
    Then Admin should able to land on " <option>" particular page from attendance page
    Examples:
      | option |
      | student |
      | program |
      | batch |
      | user |
      | class |
      | Assignment |
      | login |
