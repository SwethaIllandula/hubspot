package Pages;

import Utilpackage.DriverManager;
import Utilpackage.ElementUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage  extends DriverManager {

    @FindBy(id = "title")
    private WebElement title;

    @FindBy(id = "btnClear")
    private WebElement clearcalendar;

    @FindBy(name = "category")
    private WebElement category;

    @FindBy(xpath = "//input[@type='radio'and @value='Y']")
    private WebElement radiobutton;

    @FindBy(name= "email_alert")
    private WebElement email;

    @FindBy(name = "email_alert_contact")
    private WebElement emailcontact;

    @FindBy(name= "reminder_minutes")
    private WebElement remindminutes;

    @FindBy(name= "reminder_type")
    private WebElement remindertype;

    @FindBy(name = "contact_lookup")
    private WebElement contact;

    @FindBy(name = "client_lookup")
    private WebElement company;

    @FindBy(name = "prospect_lookup")
    private WebElement deal;

    @FindBy(name= "task_lookup")
    private WebElement task;

    @FindBy(name = "case_lookup")
    private WebElement caselook;

    @FindBy(name= "location")
    private WebElement location1;

    @FindBy(id = "notes")
    private WebElement notes;


    @FindBy(id = "meeting_notes")
    private WebElement meetingnotes;


    @FindBy(id = "tags")
    private WebElement tags;

    @FindBy(xpath = "//tr/td/input[@type='submit']")
    private WebElement savebtn;

    public CalendarPage(){
        PageFactory.initElements(driver,this);
    }
public String getTitle(){
       return driver.getTitle();
}


public void fillTheForm(String Contact,String Company,String Deal,String Task,String Case){
        title.sendKeys("Mrs");
    ElementUtils.selectDropDown(category,"Important");
    radiobutton.click();
    email.click();
    emailcontact.click();
    ElementUtils.selectDropDown(remindminutes,"2 Hours");
    ElementUtils.selectDropDown(remindertype,"Via Email");
    contact.sendKeys(Contact);
    company.sendKeys(Company);
    deal.sendKeys(Deal);
    task.sendKeys(Task);
    caselook.sendKeys(Case);}

    public void form(String Tags, String location,String Notes, String Minutes){
        tags.sendKeys(Tags);
        location1.sendKeys(location);
        notes.sendKeys(Notes);
        meetingnotes.sendKeys(Minutes);

    }
public void saveTheDetails(){
        savebtn.click();
}
}



