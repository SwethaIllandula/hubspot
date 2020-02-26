package RegressionSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class CasualRuns {

     static WebDriver driver;

    @Test
    public void checkLocators(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://classic.freecrm.com/index.html");
        driver.findElement(By.name("username")).sendKeys("Peppapi");
        driver.findElement(By.name("password")).sendKeys("Swetha22");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

       //WebElement element= driver.findElement(By.xpath("//a[@title='Calendar']"));
        driver.switchTo().frame("mainpanel");
        //WebElement calendar = driver.findElement(By.linkText("Calendar"));
        WebElement calendar = driver.findElement(By.xpath("//li/a[@title='Calendar']"));
        Actions action = new Actions(driver);
        action.moveToElement(calendar).build().perform();
       // calendar.click();
        WebElement newevent= driver.findElement(By.cssSelector("a[title='New Event']"));
        action.moveToElement(newevent).build().perform();
        newevent.click();
       // driver.quit();

    }
}
