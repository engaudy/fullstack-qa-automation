package com.demoblaze.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class WaitUtils {

    private final WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForSeconds(Integer seconds) {
        int timeout = (seconds == null) ? 5 : seconds;

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        long endTime = System.currentTimeMillis() + timeout * 1000L;

        wait.until(driver -> System.currentTimeMillis() >= endTime);
    }

}
