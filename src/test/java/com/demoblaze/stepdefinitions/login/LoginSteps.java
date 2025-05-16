package com.demoblaze.stepdefinitions.login;

import com.demoblaze.pages.HomePage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    public static WebDriver driver;
    private HomePage homePage;

    @Given("I am on the DemoBlaze homepage")
    public void i_am_on_the_demo_blaze_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.open();
    }

    @When("I open the login modal")
    public void i_open_the_login_modal() {
        homePage.openLoginModal();
        homePage.waitForLoginModal();
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        homePage.enterUsername(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        homePage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        homePage.clickLoginButton();
    }

    @Then("I should see the user logged in as {string}")
    public void i_should_see_the_user_logged_in_as(String expectedUsername) {
        String loggedUserText = homePage.waitForUserLoggedName();
        Assert.assertTrue(loggedUserText.contains(expectedUsername));
        driver.quit();
    }

    @Then("I should see a login error message")
    public void i_should_see_a_login_error_message() {
            homePage.waitForLoginAlert();
            String alertText = homePage.getLoginAlertText();
            Assert.assertTrue(alertText.contains("User does not exist.") || alertText.contains("Wrong password."));
    }
}
