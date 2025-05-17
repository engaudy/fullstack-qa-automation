Feature: User API tests

  @regression
  Scenario: Create a new user with details from table
    Given I create a new user with the following details:
      | id | username  | firstName | lastName  | email                 | password | phone      | userStatus |
      | 0  | demoUser  | Audy      | Chavarria | chavarria1@gmail.com  | Zaq2025  | 1234567890 | 1          |
    When I send the create user request
    Then I should receive a successful response

  @regression
  Scenario: Get the created user
    When I fetch the user "demoUser"
    Then I should receive status code 200

  @regression
  Scenario: Delete the user
    When I delete the user "demoUser"
    Then I should receive status code 200
