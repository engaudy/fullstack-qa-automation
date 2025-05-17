package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;


    private final By placeOrder = By.xpath("//button[text()='Place Order']");
    private final By productAdded = By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPlaceOrder(){
        driver.findElement(placeOrder).click();
    }

    public String getProductAdded() {
        return driver.findElement(productAdded).getText();
    }
}
