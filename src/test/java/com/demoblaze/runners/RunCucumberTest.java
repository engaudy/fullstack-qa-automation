package com.demoblaze.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.demoblaze.stepdefinitions",
        tags = "@login or @category",
        plugin = {"pretty"}
)

public class RunCucumberTest {
}