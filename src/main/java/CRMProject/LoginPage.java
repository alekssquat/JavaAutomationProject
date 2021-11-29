package CRMProject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(css = "div[class=input-prepend] > input[name=_username]")
    private WebElement loginField;

    @FindBy(css = "input[name=_password][id=prependedInput2]")
    private WebElement passwordField;

    public LoginPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public LoginPage logIn(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password+Keys.ENTER);
        return this;
    }
}
