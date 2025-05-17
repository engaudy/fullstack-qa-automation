Feature: Pet API tests

  @regression
  Scenario: Create a new pet with details from table
    Given I create a new pet with the following details
      | id  | name     | category_id | category_name | status  |
      | 10  | Max      | 1           | Dog            | available |
    When I send the create pet request
    Then I should receive a successful pet response

  @regression
  Scenario: Get the created pet
    When I fetch the pet with id 10
    Then I should receive status code 200

  @regression
  Scenario: Delete the pet
    When I delete the pet with id 10
    Then I should receive status code 200
