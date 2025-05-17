package com.demoblaze.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

    private final WebDriver driver;
    private final By nameInput = By.id("name");
    private final By countryInput = By.id("country");
    private final By cityInput = By.id("city");
    private final By creditCardInput = By.id("card");
    private final By monthInput = By.id("month");
    private final By yearInput = By.id("year");
    private final By purchaseButton = By.xpath("//button[text()='Purchase']");
    private final By confirmationDialog = By.xpath("//h2[contains(text(), 'Thank you')]");
    private final By confirmationOkButton = By.xpath("//button[text()='OK']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterCountry(String country) {
        driver.findElement(countryInput).clear();
        driver.findElement(countryInput).sendKeys(country);
    }

    public void enterCity(String city) {
        driver.findElement(cityInput).clear();
        driver.findElement(cityInput).sendKeys(city);
    }

    public void enterCreditCard(String cardNumber) {
        driver.findElement(creditCardInput).clear();
        driver.findElement(creditCardInput).sendKeys(cardNumber);
    }

    public void enterMonth(String month) {
        driver.findElement(monthInput).clear();
        driver.findElement(monthInput).sendKeys(month);
    }

    public void enterYear(String year) {
        driver.findElement(yearInput).clear();
        driver.findElement(yearInput).sendKeys(year);
    }

    public void clickPurchase() {
        driver.findElement(purchaseButton).click();
    }

    public String getConfirmationMessage() {
        WebElement dialog = driver.findElement(confirmationDialog);
        return dialog.findElement(confirmationDialog).getText();
    }

    public void confirmOk() {
        driver.findElement(confirmationOkButton).click();
    }
}
