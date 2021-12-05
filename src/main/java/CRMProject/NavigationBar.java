package CRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar {
    private WebDriver driver;

    @FindBy(css = "#main-menu > ul > li:nth-child(3) > a > span")
    private WebElement contractors;

    @FindBy(css = "li[data-route=\"crm_project_my\"]")
    private WebElement contacts;

    @FindBy(css = "i[class=\"icon-search\"]")
    private WebElement searchIcon;

    @FindBy(id = "search-bar-search")
    private WebElement searchBar;

    @FindBy(css = "#main-menu > ul > li:nth-child(3) > a > span")
    private WebElement contactUL;

    public WebElement getContactUL() {
        return contactUL;
    }

    @FindBy(css = "li[data-route=\"crm_project_my\"]") //элемент в выпадающем списке
    private WebElement myProjectLi;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[1]/a/span")
    private WebElement contractorsUL;

    @FindBy(css = "li[data-route=\"crm_contact_index\"]") //элемент в выпадающем списке
    private WebElement contactsLi;




    public NavigationBar (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public NavigationBar openProjects(){
        Actions openProjects = new Actions(driver);
        openProjects.moveToElement(contactUL);
        openProjects.moveToElement(myProjectLi);
        openProjects.click().build().perform();
        return this;
    }

    public NavigationBar searchProjectByName(String projectName){
        searchIcon.click();
        searchBar.sendKeys(projectName+Keys.ENTER);
        driver.findElement(By.linkText(projectName)).click();
        System.out.println("проект найден и открыт");
        deleteProject();
        System.out.println("проект удален");
        return this;
    }

    //элименты в открытом проекте
    public void deleteProject(){
        driver.findElement(By.cssSelector("a[class=\" btn icons-holder-text no-hash remove-button\"]")).click();
        driver.findElement(By.cssSelector("a[class=\"btn ok btn-primary\"]")).click();
    }

    public NavigationBar openContacts(){
        Actions openContacts = new Actions(driver);
        openContacts.moveToElement(contractorsUL);
        openContacts.moveToElement(contactsLi);
        openContacts.click().build().perform();
        return this;
    }
}
