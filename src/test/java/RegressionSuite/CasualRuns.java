package RegressionSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class CasualRuns {

     static WebDriver driver;


    public void checkLocators() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://classic.freecrm.com/index.html");
        driver.findElement(By.name("username")).sendKeys("Peppapi");
        driver.findElement(By.name("password")).sendKeys("Swetha22");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

       //WebElement element= driver.findElement(By.xpath("//a[@title='Calendar']"));
        driver.switchTo().frame("mainpanel");
        //WebElement calendar = driver.findElement(By.linkText("Calendar"));
        //WebElement calendar = driver.findElement(By.xpath("//li/a[@title='Calendar']"));
        //Actions action = new Actions(driver);
        ///action.moveToElement(calendar).build().perform();
       // calendar.click();
        //WebElement newevent= driver.findElement(By.cssSelector("li>a[title='New Event']"));
       // action.moveToElement(newevent).build().perform();
        //newevent.click();

       List<WebElement> links= driver.findElements(By.tagName("a"));
       links.addAll(driver.findElements(By.tagName("img")));
       System.out.println("total links is:  " + links.size());

       List<WebElement>activelinks = new ArrayList<WebElement>();
       for(int i=0; i<links.size();i++) {
           System.out.println(links.get(i).getAttribute("href"));
           if (links.get(i).getAttribute("href") != null && (!links.get(i).getAttribute("href").contains("javascript"))) {
               activelinks.add(links.get(i));
           }
       }

       System.out.println("Active links are: " + activelinks.size());
               for (int j = 0; j < activelinks.size(); j++) {
                   //if (links.get(j).getAttribute("href") != null ) {
                      HttpURLConnection connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
                       connection.connect();
                       String response = connection.getResponseMessage();
                       System.out.println(activelinks.get(j).getAttribute("href" )+ "--->" + response);
                       connection.disconnect();

                   }


              // }










      /* // driver.quit();
        driver.findElement(By.cssSelector("[id='title']")).sendKeys("Mrs");
        driver.findElement(By.cssSelector("[id='btnClear']")).click();
       WebElement date= driver.findElement(By.id("fieldId_start"));
        WebElement dropdown =driver.findElement(By.name("category"));
        dropdown.click();
        selectDropDown(dropdown,"Optional");
        Thread.sleep(5000);
       driver.findElement(By.xpath("//input[@type='radio'and @value='Y']")).click();
       driver.findElement(By.name("email_alert")).click();
       driver.findElement(By.name("email_alert_contact")).click();
       WebElement reminder=driver.findElement(By.name("reminder_minutes"));
       selectDropDown(reminder,"1 Hour");
       WebElement email=driver.findElement(By.name("reminder_type"));
       selectDropDown(email,"Via Email");
       driver.findElement(By.name("contact_lookup")).sendKeys("srikanth");
        driver.findElement(By.name("client_lookup")).sendKeys("mavenIT");
        driver.findElement(By.name("prospect_lookup")).sendKeys("jobdeal");
        driver.findElement(By.name("task_lookup")).sendKeys("qa task");
        driver.findElement(By.name("case_lookup")).sendKeys("test");
        driver.findElement(By.name("location")).sendKeys("hello world");
        driver.findElement(By.id("notes")).sendKeys("first meeting of team ");
        driver.findElement(By.id("meeting_notes")).sendKeys("get laptops to perform seminar");
        driver.findElement(By.id("tags")).sendKeys("Automation Tags");
        driver.findElement(By.id("tags")).sendKeys("Automation Tags");

*/

    }


    public void selectDateByJavaScriptExecutor(WebDriver driver,WebElement element,String dateval){
        //JavascriptExecutor js = ((JavascriptExecutor)driver);
       // js.executeScript("arguments[0].setAttribute('value','"+dateval+"')" element);
        //String script=("arguments[0].setAttribute('value','"+dateval+"');";
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].setAttribute('value','"+dateval+"');",element);
        //jse.executeScript(script, element);
    }

    public void selectDropDown(WebElement element,String text){
        Select select= new Select(element);
        select.selectByVisibleText(text);
    }
}
