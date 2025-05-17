@flow
Feature: Comprar un producto en DemoBlaze

  Scenario Outline: Comprar un producto y completar el checkout
    Given I am on the DemoBlaze homepage
    And I open the login modal
    And I enter username "<username>"
    And I enter password "<password>"
    And I click the login button
    And I select the category "<category>"
    And I select the product "<product>" to the product page
    And I add the product to the cart "<product>"
    And I open the cart
    When I should see "<product>" in the cart to place order
    And I fill the order form with name "Audy Chavarria", country "Colombia", city "Medellin", credit card "1234 5678 9876 5432", month "12", year "2027"
    And I confirm the purchase
    Then I should see a confirmation message
    Then I should see the user logged in as "<username>"

    Examples:
      | username | password | category  | product      |
      | admin    | admin    | Monitors  | ASUS Full HD |