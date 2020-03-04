package steps;

import Pages.CalendarPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilpackage.DriverManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CalendarStepDefinitions  extends DriverManager {

    HomePage homePage ;
    LoginPage loginPage;
    CalendarPage calendarPage;

    @Given("^User is on CalendarPage$")
    public void user_is_on_CalendarPage() throws Throwable {
        DriverManager.openBrowser();
        loginPage= new LoginPage();
        loginPage.login();
        homePage = new HomePage();
        homePage.checkUserName();
        homePage.calender();
    }

    @When("^User fills the form in the  \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_fills_the_form_in_the_and_and_and_and(String Contact, String Company, String Deal, String Task, String Case) throws Throwable {
       calendarPage= new CalendarPage();
        String calendartitle = calendarPage.getTitle();
        Assert.assertEquals("CRMPRO", calendartitle);
        calendarPage.fillTheForm( "Contact", "Company", "Deal", "Task", "Case");
    }




    @When("^User also fills the form with \"([^\"]*)\" and  \"([^\"]*)\" and \"([^\"]*)\" and  \"([^\"]*)\"$")
    public void user_also_fills_the_form_with_and_and_and(String Tags, String location, String Notes, String Minutes) throws Throwable {
       calendarPage.form( "Tags", "location", "Notes","Minutes");

    }

    @Then("^User should be able to save the details$")
    public void user_should_be_able_to_save_the_details() throws Throwable {
        calendarPage.saveTheDetails();

    }



}
