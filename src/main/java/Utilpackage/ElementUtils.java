package Utilpackage;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ElementUtils extends DriverManager{

    public static String TESTDATA_SHEET_PATH = "com.app.hubspot.com/src/main/resources";

   public  static Workbook book;
    static Sheet sheet;
    static JavascriptExecutor js;

    public void switchToFrame() {
        driver.switchTo().frame("mainpanel");
    }

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                // System.out.println(data[i][k]);
            }
        }
        return data;
    }


   public static void actionsToMoveToElement(WebDriver driver,WebElement element){
      // WebDriver driver;
     // driver= new ChromeDriver();
       Actions action =new Actions(driver);
       action.moveToElement(element);
       action.build().perform();
   }

  public static void actionToClickElement(WebDriver driver, WebElement element) {
      Actions action =new Actions(driver);
      //action.moveToElement(element);
      //action.build().perform();
      element.click();
  }

    public static void selectDropDown(WebElement element,String text){
        Select select= new Select(element);
        select.selectByVisibleText(text);
    }


public static void handleFrames(WebElement element){
        driver.switchTo().frame(element);
}


public void selectDropDownByIndex(WebElement element,int number){
        Select index= new Select(element);
                index.selectByIndex(number);
}

    public void selectDropDownByValue(WebElement element,String value){
        Select index= new Select(element);
        index.selectByValue(value);
    }













}
