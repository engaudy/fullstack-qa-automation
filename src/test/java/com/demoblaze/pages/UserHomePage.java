package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.List;


public class UserHomePage {

    private WebDriver driver;

    public UserHomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By categoryLocator(String category) {
        return By.xpath("//*[@id='itemc' and text()='" + category + "']");
    }

    public WebElement phonesCategory() {
        return driver.findElement(categoryLocator("Phones"));
    }

    public WebElement laptopsCategory() {
        return driver.findElement(categoryLocator("Laptops"));
    }

    public WebElement monitorsCategory() {
        return driver.findElement(categoryLocator("Monitors"));
    }

    private final By productLinksLocator = By.xpath("//*[@id='tbodyid']//h4/a");

    public void clickCategory(String category) {
        String xpath = String.format("//a[@id='itemc' and text()='%s']", category);
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(StaleElementReferenceException.class);

        fluentWait.until(driver -> {
            WebElement element = driver.findElement(By.xpath(xpath));
            element.click();
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title")));
            return true;
        });
    }

    public List<WebElement> getProductLinks() {
        return driver.findElements(productLinksLocator);
    }

    public By getProductLinksLocator() {
        return productLinksLocator;
    }

}
