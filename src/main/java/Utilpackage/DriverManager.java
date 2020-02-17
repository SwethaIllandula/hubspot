package Utilpackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver driver;
    public static Properties prop;

    public DriverManager(){
        try{
        prop= new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/config/config.properties");
        prop.load(fis);
    }
        catch (Exception e) {
            e.getMessage();
        }
        }
    public static void openBrowser(){
          String browsername= prop.getProperty("browser");
        if (browsername.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browsername.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("please specify browser");
        }
        driver.get(prop.getProperty("Url"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
public  static void quitBrowser(){
        driver.quit();
}
}
