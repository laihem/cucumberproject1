package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber .class)
@CucumberOptions(
        features = {"features"},
        glue =  {"steps"},
        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber.json",
                "html:target/cucumber-report/cucumber.html"},
        dryRun = false,
        tags = "@p7"

)
public class TestRunner {
}
