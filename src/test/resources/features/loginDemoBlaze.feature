Feature: Login to DemoBlaze

  @login
  Scenario Outline: User tries to log in with credentials
    Given I am on the DemoBlaze homepage
    When I open the login modal
    And I enter username "<username>"
    And I enter password "<password>"
    And I click the login button
    Then I should see the user logged in as "<username>"

    Examples:
      | username | password |
      | admin    | admin    |

  @login
  Scenario Outline: User tries to log in with invalid credentials
    Given I am on the DemoBlaze homepage
    When I open the login modal
    And I enter username "<username>"
    And I enter password "<password>"
    And I click the login button
    Then I should see a login error message

    Examples:
      | username | password |
      | audy     | wrong    |

