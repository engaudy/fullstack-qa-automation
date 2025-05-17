@categories
Feature: Category Validation on DemoBlaze

  Scenario Outline: Validate that each category shows correct products
    Given I am on the DemoBlaze homepage
    When I open the login modal
    And I enter username "admin"
    And I enter password "admin"
    And I click the login button
    And I select the category "<category>"
    Then I should see only products related to "<category>"

    Examples:
      | category  |
      | Phones    |
      | Laptops   |
      | Monitors  |
