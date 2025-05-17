
package com.demoblaze.ui.stepdefinitions;

import com.demoblaze.ui.pages.HomePage;
import com.demoblaze.ui.pages.OrderPage;
import com.demoblaze.ui.pages.ProductPage;
import com.demoblaze.ui.pages.UserHomePage;
import com.demoblaze.ui.pages.CartPage;
import com.demoblaze.ui.utils.CategoryUtils;
import com.demoblaze.ui.utils.WaitUtils;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class DemoBlazeSteps {

    private static WebDriver driver;
    private static HomePage homePage;
    private static UserHomePage userHomePage;
    private static OrderPage orderPage;
    private static ProductPage productPage;
    private static CartPage cartPage;
    WaitUtils waitUtils = new WaitUtils(driver);

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        userHomePage = new UserHomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        orderPage = new OrderPage(driver);
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


    //Flow to add products
    @When("I select the product {string} to the product page")
    public void i_add_the_product_to_the_product_page(String productName) {
        waitUtils.waitForSeconds(null);
        userHomePage.clickProductByName(productName);
    }

    //To validate if the product is the same before add to the cart
    @When("I add the product to the cart {string}")
    public void i_add_the_product_to_the_cart(String productName) {
        waitUtils.waitForSeconds(null);
        String displayedProduct = userHomePage.getTextAnyProduct();
        if (displayedProduct.equalsIgnoreCase(productName)) {
            productPage.clickAddToCart();
        } else {
            throw new AssertionError("Expected product '" + productName + "', but found '" + displayedProduct + "'");
        }
    }

    @When("I open the cart")
    public void i_open_the_cart() {
        waitUtils.waitForSeconds(null);
        userHomePage.clickCart();
    }

    @When("I should see {string} in the cart to place order")
    public void i_should_see_product_in_cart(String productName) {
        waitUtils.waitForSeconds(null);
        String displayedProduct = cartPage.getProductAdded();
        if (displayedProduct.equalsIgnoreCase(productName)) {
            cartPage.clickPlaceOrder();
        } else {
            throw new AssertionError("Expected product '" + productName + "', but found '" + displayedProduct + "'");
        }
    }

    @When("I should see in the cart to place order")
    public void i_should_see_product_in_cart() {
        waitUtils.waitForSeconds(null);
        cartPage.clickPlaceOrder();
    }

    @When("I fill the order form with name {string}, country {string}, city {string}, credit card {string}, month {string}, year {string}")
    public void i_fill_the_order_form(String name, String country, String city, String creditCard, String month, String year) {
        waitUtils.waitForSeconds(null);
        orderPage.enterName(name);
        orderPage.enterCountry(country);
        orderPage.enterCity(city);
        orderPage.enterCreditCard(creditCard);
        orderPage.enterMonth(month);
        orderPage.enterYear(year);
    }

    @When("I confirm the purchase")
    public void i_confirm_the_purchase() {
        waitUtils.waitForSeconds(null);
        orderPage.clickPurchase();

    }

    @Then("I should see a confirmation message")
    public void i_should_see_confirmation_message() {
        waitUtils.waitForSeconds(null);
    String confirmation = orderPage.getConfirmationMessage();
        assertTrue(confirmation.contains("Thank you for your purchase"));
        orderPage.confirmOk();
        waitUtils.waitForSeconds(null);
    }

}
