package com.demoblaze.api.stepdefinitions;

import com.demoblaze.api.models.User;
import com.demoblaze.api.models.Pet;
import com.demoblaze.api.models.Order;
import com.demoblaze.api.utils.ApiUtils;
import static org.hamcrest.Matchers.is;
import io.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class SwaggerStepDefinitions {

    private User user;
    private Pet pet;
    private Order order;
    private Response response;

    //USER
    @Given("I create a new user with the following details:")
    public void i_create_a_new_user_with_the_following_details(DataTable dataTable) {
        Map<String, String> userData = dataTable.asMaps().get(0);

        user = new User(
                Integer.parseInt(userData.get("id")),
                userData.get("username"),
                userData.get("firstName"),
                userData.get("lastName"),
                userData.get("email"),
                userData.get("password"),
                userData.get("phone"),
                Integer.parseInt(userData.get("userStatus"))
        );
    }

    @When("I send the create user request")
    public void i_send_the_create_user_request() {
        response = ApiUtils.createUser(user);
    }

    @Then("I should receive a successful response")
    public void i_should_receive_a_successful_response() {
        response.then()
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"));
    }

    @When("I delete the user {string}")
    public void deleteUser(String username) {
        ApiUtils.deleteUser(username);
    }

    @When("I fetch the user {string}")
    public void fetchUser(String username) {
        ApiUtils.fetchUser(username);
    }

    @Then("I should receive status code {int}")
    public void verifyStatusCode(int statusCode) {
        restAssuredThat(response -> response.statusCode(is(statusCode)));
    }

    //PET
    @Given("I create a new pet with the following details")
    public void i_create_a_new_pet_with_the_following_details(DataTable dataTable) {
        Map<String, String> petData = dataTable.asMaps().get(0);

        int id = Integer.parseInt(petData.get("id"));
        String name = petData.get("name");
        int categoryId = Integer.parseInt(petData.get("category_id"));
        String categoryName = petData.get("category_name");
        String status = petData.get("status");

        pet = new Pet(id, name, new Pet.Category(categoryId, categoryName), status);
    }

    @When("I send the create pet request")
    public void i_send_the_create_pet_request() {
        response = ApiUtils.createPet(pet);
    }

    @When("I fetch the pet with id {int}")
    public void i_fetch_the_pet_with_id(Integer petId) {
        ApiUtils.fetchPet(petId);
    }

    @When("I delete the pet with id {int}")
    public void i_delete_the_pet_with_id(Integer petId) {
        ApiUtils.deletePet(petId);
    }

    @Then("I should receive a successful pet response")
    public void i_should_receive_a_successful_pet_response() {
        response.then()
                .statusCode(200)
                .body("id", equalTo(pet.id))
                .body("name", equalTo(pet.name))
                .body("category.id", equalTo(pet.category.id))
                .body("category.name", equalTo(pet.category.name))
                .body("status", equalTo(pet.status));
    }

    //STORE
    @Given("I create a new store order with the following details:")
    public void i_create_a_new_store_order_with_the_following_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        order = new Order(
                Integer.parseInt(data.get("id")),
                Integer.parseInt(data.get("petId")),
                Integer.parseInt(data.get("quantity")),
                data.get("shipDate"),
                data.get("status"),
                Boolean.parseBoolean(data.get("complete"))
        );
    }

    @When("I send the create order request")
    public void i_send_the_create_order_request() {
        response = ApiUtils.createOrder(order);
    }

    @Then("I should receive a successful store response")
    public void i_should_receive_a_successful_store_response() {
        response.then()
                .statusCode(200)
                .body("id", equalTo(order.id))
                .body("petId", equalTo(order.petId))
                .body("quantity", equalTo(order.quantity))
                .body("status", equalTo(order.status))
                .body("complete", equalTo(order.complete));
    }

    @When("I fetch the store order with id {int}")
    public void i_fetch_the_store_order_with_id(Integer id) {
        ApiUtils.fetchOrder(id);
    }

    @When("I delete the store order with id {int}")
    public void i_delete_the_store_order_with_id(Integer id) {
       ApiUtils.deleteOrder(id);
    }

    @Then("I should receive store status code {int}")
    public void i_should_receive_store_status_code(Integer statusCode) {
        //response.then().statusCode(statusCode);
    }
}
