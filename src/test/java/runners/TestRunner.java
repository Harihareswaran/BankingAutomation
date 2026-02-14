package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"StepDefinition","hooks"},
    plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber-report.json"},       // JSON for Jenkins
    monochrome = true,
    tags = "@smoke or @regression"  // Runs ALL scenarios with any of these tags
)
public class TestRunner extends AbstractTestNGCucumberTests { }
