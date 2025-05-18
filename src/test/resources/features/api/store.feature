Feature: Store API tests

  @regression
  Scenario: Place a new order for a pet
    Given I create a new store order with the following details:
      | id | petId | quantity | shipDate                  | status   | complete |
      | 2  | 10    | 1        | 2025-05-18T10:00:00.000Z | placed   | true     |
    When I send the create order request
    Then I should receive a successful store response

  @regression
  Scenario: Get the created store order by ID
    When I fetch the store order with id 2
    Then I should receive store status code 200

  @regression
  Scenario: Delete the store order by ID
    When I delete the store order with id 2
    Then I should receive store status code 200
