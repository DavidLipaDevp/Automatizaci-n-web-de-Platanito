package com.rocket.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber/cucumber-report.html",
                "json:target/cucumber/cucumber.json"
        },
        stepNotifications = true,
        features = "src/test/resources/features",
        glue = "com.rocket.stepsdefinitions",
        tags = "@TestRegresivo"

)
public class RunnerTest {
}
