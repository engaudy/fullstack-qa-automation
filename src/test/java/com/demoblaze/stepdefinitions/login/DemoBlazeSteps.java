
package com.demoblaze.stepdefinitions.login;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.UserHomePage;
import com.demoblaze.utils.CategoryUtils;
import com.demoblaze.utils.WaitUtils;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class DemoBlazeSteps {

    private static WebDriver driver;
    private static HomePage homePage;
    private static UserHomePage userHomePage;
    WaitUtils waitUtils = new WaitUtils(driver);

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        userHomePage = new UserHomePage(driver);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the DemoBlaze homepage")
    public void i_am_on_the_demo_blaze_homepage() {
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

    @When("I select the category {string}")
    public void i_select_the_category(String category) {
        userHomePage.clickCategory(category);
    }

    @Then("I should see the user logged in as {string}")
    public void i_should_see_the_user_logged_in_as(String expectedUsername) {
        String loggedUserText = homePage.waitForUserLoggedName();
        assertAll("Verify logged in user",
                () -> assertTrue(loggedUserText.contains(expectedUsername),
                        () -> "Expected logged in user to contain: '" + expectedUsername + "', but was: '" + loggedUserText + "'")
        );
    }

    @Then("I should see a login error message")
    public void i_should_see_a_login_error_message() {
        homePage.waitForLoginAlert();
        String alertText = homePage.getLoginAlertText();
        assertTrue(
                alertText.contains("User does not exist.") || alertText.contains("Wrong password."),
                "Expected error message to contain either 'User does not exist.' or 'Wrong password.', but was: '" + alertText + "'"
        );
    }

    @Then("I should see only products related to {string}")
    public void i_should_see_only_products_related_to(String category) {

        System.out.println("Validating products for category: '" + category + "'");

        waitUtils.waitForSeconds(null);

        List<WebElement> productLinks = userHomePage.getProductLinks();

        System.out.println("Products found:");
        for (WebElement productLink : productLinks) {
            System.out.println("- " + productLink.getText());
        }

        List<String> expectedKeywords = CategoryUtils.getExpectedKeywordsForCategory(category);

        for (WebElement productLink : productLinks) {
            String productName = productLink.getText().toLowerCase();

            boolean matchesCategory = expectedKeywords.stream()
                    .anyMatch(keyword -> productName.contains(keyword.toLowerCase()));

            if (!matchesCategory) {
                throw new AssertionError("Unexpected product in " + category + " category: '" + productName + "'");
            }
        }
    }
}
