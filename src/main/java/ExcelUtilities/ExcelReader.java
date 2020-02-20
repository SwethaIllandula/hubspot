package ExcelUtilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openxml4j.exceptions.InvalidFormatException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    public static Workbook book;
    public static Sheet sheet;

    public String sheetpath= "C:\\MyFirstProjects\\com.app.hubspot.com\\src\\main\\resources";


    public Object[][]  getTestData(String sheetname)  {
            FileInputStream file = null;
        try {
            file= new FileInputStream(sheetpath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();}
            try{
              book=  WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();}
            sheet = book.getSheet(sheetname);

Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    for(int i =0;i<sheet.getLastRowNum();i++){
        for(int j=0; j<sheet.getRow(0).getLastCellNum();j++){
            data[i][j] = sheet.getRow(i+1).getCell(j).toString();
        }
    }
return data;
        }

    }





