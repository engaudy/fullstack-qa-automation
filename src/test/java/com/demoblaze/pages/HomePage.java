package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By loginButton = By.id("login2");
    private final By usernameInput = By.id("loginusername");
    private final By passwordInput = By.id("loginpassword");
    private final By modalLoginButton = By.xpath("//button[text()='Log in']");
    private final By loggedUserName = By.id("nameofuser");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.demoblaze.com/");
    }

    public void openLoginModal() {
        driver.findElement(loginButton).click();
    }

    public void enterUsername(String username) {
        WebElement userInput = driver.findElement(usernameInput);
        userInput.clear();
        userInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passInput = driver.findElement(passwordInput);
        passInput.clear();
        passInput.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(modalLoginButton).click();
    }

    public void waitForLoginModal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
    }

    public String waitForUserLoggedName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedUserName));
        return driver.findElement(loggedUserName).getText();
    }

    public void waitForLoginAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public String getLoginAlertText() {
        waitForLoginAlert();
        return driver.switchTo().alert().getText();
    }
}
