package steps;

import Pages.CalendarPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilpackage.DriverManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class HomeStepDefinition extends DriverManager {
    LoginPage loginPage;
    HomePage homePage;
    CalendarPage calendarPage;


    @Given("^user on login page$")
    public void user_on_login_page() throws Throwable {
        DriverManager.openBrowser();
        loginPage = new LoginPage();
        String Title = loginPage.getTitle();
        System.out.println(Title);
        Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", Title);
        loginPage.login(); }

    @When("^User logs into application$")
    public void user_logs_into_application() throws Throwable {
        homePage = new HomePage();
        String homeTitle = homePage.getHomeTitle();
        Assert.assertEquals("CRMPRO", homeTitle);
        Thread.sleep(5000);
        boolean flag = homePage.checkUserName();
        System.out.println(flag);
        Assert.assertTrue(flag); }

    @Then("^User should be able to  Move to calendar page and create Events$")
    public void user_should_be_able_to_Move_to_calendar_page_and_create_Events() throws Throwable {
        homePage.calender();
        String title= driver.getTitle();
        Assert.assertEquals("CRMPRO",title);


    }
}