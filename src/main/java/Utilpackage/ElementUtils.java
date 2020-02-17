package Utilpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ElementUtils {


   public void actionsToclickElement(){
       WebDriver driver;
      driver= new ChromeDriver();
       Actions action =new Actions(driver);
       action.build().perform();


   }

















}
