package com.demoblaze.api.utils;

import com.demoblaze.api.models.User;
import com.demoblaze.api.models.Pet;
import net.serenitybdd.rest.SerenityRest;
import io.restassured.response.Response;

public class ApiUtils {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    public static Response createUser(User user) {
        return SerenityRest
                .given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post("/user")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public static void deleteUser(String username) {
        SerenityRest
                .given()
                .baseUri(BASE_URL)
                .when()
                .delete("/user/{username}", username);
    }

    public static void fetchUser(String username) {
        SerenityRest
                .given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .when()
                .get("/user/" + username)
                .then()
                .log().all();
    }

    public static Response createPet(Pet pet) {
        return SerenityRest
                .given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(pet)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public static void deletePet(int petId) {
        SerenityRest
                .given()
                .baseUri(BASE_URL)
                .when()
                .delete("/pet/{petId}", petId);
    }

    public static void fetchPet(int petId) {
        SerenityRest
                .given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .when()
                .get("/pet/" + petId)
                .then()
                .log().all();
    }
}
