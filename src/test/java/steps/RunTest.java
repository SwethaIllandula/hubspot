package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Calendarpage.feature",
        glue = "/Users/swetha/dev/hubspot/src/test/java/steps/CalendarStepDefinitions.java",
        dryRun = true
)
public class RunTest {
}
