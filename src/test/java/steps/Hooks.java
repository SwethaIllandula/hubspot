package steps;

import Utilpackage.DriverManager;
import org.junit.After;
import org.junit.Before;

public class Hooks extends DriverManager {

    @Before
   public void  DriverSetUp(){
        DriverManager.openBrowser();

    }
    @After
public void tearDown(){
        DriverManager.quitBrowser();
}
}
