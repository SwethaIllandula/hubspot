package Pages;

import Utilpackage.DriverManager;
import Utilpackage.ElementUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DriverManager {

    @FindBy(xpath = "//tr/td[contains(text(),'User: swetha illan')]")
    @CacheLookup
    private WebElement userLAbel;

    @FindBy(name = "mainpanel")
     private WebElement frameElement;

    @FindBy(xpath = "//li/a[@title='Calendar']")
    private WebElement calendarlink;

    @FindBy(css = "a[title='New Event']")
    private WebElement goToNewEvent;

public HomePage(){
    PageFactory.initElements(driver,this);
}


public String getHomeTitle(){
    return driver.getTitle();
}

public boolean checkUserName(){
    ElementUtils.handleFrames(frameElement);
   return userLAbel.isDisplayed();
}
public CalendarPage calender(){
    ElementUtils.actionsToMoveToElement(driver,calendarlink);
    ElementUtils.actionsToMoveToElement(driver,goToNewEvent);
    goToNewEvent.click();
    return new CalendarPage();
}


}
