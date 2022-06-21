Feature:Testing different requests on the gorset application

  Scenario Outline:
    When I Create a new employee by providing the information name "<name>" salary "<salary>" age "<age>"
    And I verify that the employee has been created
    And I updated a name of the employee created
    And I Verify that the employee's name has been updated
    And I delete employee with same id
    Then I verify the employee has been deleted
    Examples:
      | name    | salary | age |
      | My Name | 55000  | 22  |