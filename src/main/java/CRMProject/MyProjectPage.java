package CRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProjectPage {
    private WebDriver driver;

    @FindBy(css = "div[class=\"pull-left btn-group icons-holder\"]>a[href=\"/project/create/\"]")
    private WebElement createProjectBtn;

    public MyProjectPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public MyProjectPage clickNewProjectBtn(){
        createProjectBtn.click();
        return this;
    }
}
