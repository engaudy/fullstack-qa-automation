package com.demoblaze.ui.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.demoblaze.ui.stepdefinitions",
        tags = "@login or @categories or @flowProduct or @flowNoProduct",
        plugin = {"pretty"}
)

public class RunCucumberTest {
}
