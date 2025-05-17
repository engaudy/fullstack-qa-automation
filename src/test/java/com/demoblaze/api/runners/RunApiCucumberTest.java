package com.demoblaze.api.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "com.demoblaze.api.stepdefinitions",
        tags = "@regression",
        plugin = {"pretty"}
)

public class RunApiCucumberTest {
}
