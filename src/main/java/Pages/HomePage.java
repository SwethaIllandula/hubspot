package Pages;

import Utilpackage.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DriverManager {

    @FindBy(xpath = "//tr/td[contains(text(),'User: swetha illan')]")
    @CacheLookup
    private WebElement userLAbel;


public HomePage(){
    PageFactory.initElements(driver,this);
}
public String getHomeTitle(){
    return driver.getTitle();
}

public boolean checkUserName(){
   return userLAbel.isDisplayed();
}
}
