package com.demoblaze.ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.junit.Assert;

public class SiteHealthCheck {

    private static final String HOME_URL = "https://www.demoblaze.com";

    public static void verifySiteIsUp(WebDriver driver) {
        driver.get(HOME_URL);

        boolean isLoaded = !driver.findElements(By.id("nava")).isEmpty();
        Assert.assertTrue("Demoblaze homepage is not available", isLoaded);
    }
}
