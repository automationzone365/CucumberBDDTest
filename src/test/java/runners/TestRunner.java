package runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"
        ,glue={"stepdefinitions","hooks","domainobjects","customtype"},

        plugin = {"html:target/cucumber/cucumber.html"}

)
public class TestRunner {
}
