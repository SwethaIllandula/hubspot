package Pages;

import Utilpackage.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverManager {

  @FindBy(name="username")
  private WebElement userName;

  @FindBy(name = "password")
    private  WebElement passWord;

  @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;


public LoginPage(){
    PageFactory.initElements(driver,this);
}

public String getTitle(){
   return driver.getTitle(); }

   public HomePage login(){
    userName.sendKeys(prop.getProperty("username"));
    passWord.sendKeys(prop.getProperty("password"));
    loginButton.click();
    return  new HomePage();
   }

}
