package com.demoblaze.ui.stepdefinitions.api;

import io.cucumber.java.en.*;
import net.serenitybdd.rest.SerenityRest;

public class UserStepDefinitions {

    @Given("I create a new user with username {string}")
    public void createUser(String username) {
        String requestBody = """
            {
              "id": 0,
              "username": "%s",
              "firstName": "Audy",
              "lastName": "Chavarria",
              "email": "chavarriaaudy@gmail.com",
              "password": "Zaq2025",
              "phone": "1234567890",
              "userStatus": 1
            }
            """.formatted(username);

        String BASE_URL = "https://petstore.swagger.io/v2";
        SerenityRest
                .given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/user")
                .then()
                .statusCode(200);
    }
}
