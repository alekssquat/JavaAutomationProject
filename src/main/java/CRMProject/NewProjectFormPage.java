package CRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewProjectFormPage {
    private WebDriver driver;

    @FindBy(css = "name[\"crm_project[name]\"]")
    private WebElement projectNameField;

    @FindBy(css = "div[class=\"company-container\"]>div>a>span[class=\"select2-chosen\"]")
    private WebElement companyList;

    @FindBy(name = "crm_project[priority]")
    private WebElement priorityList;

    @FindBy(name = "crm_project[financeSource]")
    private WebElement financeSource;

    @FindBy(name = "crm_project[businessUnit]")
    private WebElement businessUnit;

    @FindBy(name = "crm_project[curator]")
    private WebElement curator;

    @FindBy(name = "crm_project[rp]")
    private WebElement rp;

    @FindBy(name = "crm_project[administrator]")
    private WebElement administrator;

    @FindBy(name = "crm_project[manager]")
    private WebElement manager;

    @FindBy(css = "div[class=\"select2-container select2\"]>a>span[class=\"select2-chosen\"]")
    private WebElement mainContactSearchBar;

    @FindBy(css = "#select2-drop > div > input")
    private WebElement mainContactInputField;

    @FindBy(css = "button[class=\"btn btn-success action-button\"]")
    private WebElement saveProjectBtn;



    public NewProjectFormPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public NewProjectFormPage setProjectNameField(String projectNameField) {
        this.projectNameField.sendKeys(projectNameField);
        return this;
    }

    public NewProjectFormPage setCompanyList(String companyTitleUserTest) {
        companyList.click();
        WebElement companySearchBar = driver.findElement(By
                .cssSelector("#select2-drop > div > input"));
        companySearchBar.sendKeys(companyTitleUserTest);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.cssSelector("span[class=\"select2-match\"]"))));
        companySearchBar.sendKeys(Keys.ENTER);
        return this;
    }

    public NewProjectFormPage setPriorityList() {
        this.priorityList.sendKeys(Keys.ARROW_UP);
        return this;
    }

    public NewProjectFormPage setFinanceSource() {
        this.financeSource.sendKeys(Keys.ARROW_DOWN);
        return this;
    }

    public NewProjectFormPage setBusinessUnit() {
        this.businessUnit.sendKeys(Keys.ARROW_DOWN);
        return this;
    }

    public NewProjectFormPage setCurator(String curator) {
        this.curator.sendKeys(curator);//"Скоробогатова"
        return this;
    }

    public NewProjectFormPage setRp(String rp) {
        this.rp.sendKeys(rp);//"Дедова"
        return this;
    }

    public NewProjectFormPage setAdministrator(String administrator) {
        this.administrator.sendKeys(administrator);//"Карпова"
        return this;
    }

    public NewProjectFormPage setManager(String manager) {
        this.manager.sendKeys(manager); //"Прохорова"
        return this;
    }

    public NewProjectFormPage setMainContactSearchBar(String lastNameUserTest,String firstNameUserTest) {
        this.mainContactSearchBar = mainContactSearchBar;
        mainContactInputField.sendKeys(lastNameUserTest+" "+firstNameUserTest+Keys.ENTER);
        return this;
    }

    public NewProjectFormPage clickSaveProjectBtn() {
        this.saveProjectBtn.click();
        return this;
    }
}
