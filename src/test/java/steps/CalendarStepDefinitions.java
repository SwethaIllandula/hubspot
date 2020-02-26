package steps;

import Utilpackage.DriverManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalendarStepDefinitions  extends DriverManager {

    @Given("^User is on CalendarPage$")
    public void user_is_on_CalendarPage() throws Throwable {

    }

    @When("^User fills the form in the \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_fills_the_form_in_the_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
    }

    @Then("^User also fills the form with \"([^\"]*)\" and  \"([^\"]*)\" and \"([^\"]*)\" and  \"([^\"]*)\"$")
    public void user_also_fills_the_form_with_and_and_and(String arg1, String arg2, String arg3, String arg4) throws Throwable {

    }

    @Then("^User should be able to save the details$")
    public void user_should_be_able_to_save_the_details() throws Throwable {

    }



}
