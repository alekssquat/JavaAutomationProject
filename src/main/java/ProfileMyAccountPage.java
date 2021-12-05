import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileMyAccountPage {
    private WebDriver driver;

    @FindBy(css = "a[href=\"https://shop.tastycoffee.ru/my-account\"]")
    private WebElement myAccountLink;

    @FindBy(css = "input[name=\"legal_name\"]")
    private WebElement legalNameField;

    @FindBy(id = "submit-update-account")
    private WebElement saveBtn;


    public ProfileMyAccountPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        myAccountLink.click();
    }

    public WebElement getLegalNameField() {
        return legalNameField;
    }

    public WebElement getMyAccountLink() {
        return myAccountLink;
    }

    public ProfileMyAccountPage inputLegalName(){
        legalNameField.sendKeys("1");
        return this;
    }



    public ProfileMyAccountPage saveUpdates(){
        saveBtn.click();
        return this;
    }

}
