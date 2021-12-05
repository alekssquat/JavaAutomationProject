package CRMProject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
    private WebDriver driver;

    @FindBy(css = "div[class=\"pull-left btn-group icons-holder\"]>a[href=\"/contact/create\"]")
    private WebElement createContact;

    public ContactsPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public ContactsPage clickCreateContact(){
        createContact.click();
        return this;
    }
}
