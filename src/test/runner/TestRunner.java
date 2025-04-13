package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Test",
        plugin = {"pretty", "html:target/cucumber-report", "json:target/cucumber.json"},
        glue = {"steps", "utility"},
        features = "src/test/features")
public class TestRunner {

}
