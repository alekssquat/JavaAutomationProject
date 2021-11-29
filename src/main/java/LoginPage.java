import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(css = "button[class=\"greyLink enterOpen\"]")
    private WebElement entranceForm;

    @FindBy(id = "email")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    public LoginPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public LoginPage logIn(String loginEmail, String password){
        entranceForm.click();
        loginField.sendKeys(loginEmail);
        passwordField.sendKeys(password+ Keys.ENTER);
        return this;
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }
}
