package CRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewContactForm {
    private WebDriver driver;

    @FindBy(name = "crm_contact[lastName]")
    private WebElement lastNameInput;

    public NewContactForm setLastNameInput(String lastname) {
        this.lastNameInput.sendKeys(lastname);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    private WebElement firstNameInput;

    public NewContactForm setFirstNameInput(String firstName) {
        this.firstNameInput.sendKeys(firstName);
        return this;
    }

    @FindBy(css = "div[class=\"company-container\"]>div>a>span[class=\"select2-chosen\"]")
    private WebElement companyDropList;

    @FindBy(css = "#select2-drop > div > input")
    private WebElement inputCompanyDropElement;

    @FindBy(css = "span[class=\"select2-match\"]")
    private WebElement matchInputCompany;

    @FindBy(css = "input[name=\"crm_contact[jobTitle]\"]")
    private WebElement jobTitle;

    public NewContactForm setJobTitle(String jobTitle) {
        this.jobTitle.sendKeys(jobTitle);
        return this;
    }

    @FindBy(name = "crm_contact[status]")
    private WebElement status;

    public NewContactForm setStatus(String status) {
        this.status.sendKeys(status+Keys.ENTER);
        return this;
    }

    public NewContactForm (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public NewContactForm setCompanyTitle(String companyTitleUserTest) {
        this.companyDropList.click();
        inputCompanyDropElement.sendKeys(companyTitleUserTest);

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .elementToBeClickable(matchInputCompany));

        inputCompanyDropElement.sendKeys(Keys.ENTER);

        return this;
    }
}
