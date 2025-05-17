Feature: Purchase a product on DemoBlaze

  @flowProduct
  Scenario Outline: Purchase a product and complete the checkout

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

  @flowNoProduct
  Scenario Outline: Trying a purchase without any product

    Given I am on the DemoBlaze homepage
    And I open the login modal
    And I enter username "<username>"
    And I enter password "<password>"
    And I click the login button
    And I open the cart
    When I should see in the cart to place order
    And I fill the order form with name "Audy Chavarria", country "Colombia", city "Medellin", credit card "1234 5678 9876 5432", month "12", year "2027"
    And I confirm the purchase
    Then I should see a confirmation message
    Then I should see the user logged in as "<username>"

    Examples:
      | username | password |
      | admin    | admin    |

  @wip
  Scenario: Change the quantity of a product in the cart and validate that the total price updates correctly
    # Given the user has added a product to the cart
    # And the user is on the cart page
    # When the user changes the quantity of the product
    # Then the total price should be updated accordingly
    # And the updated total should reflect the new quantity multiplied by the product price