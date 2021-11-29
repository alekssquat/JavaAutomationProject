import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(css = "a[href=\"https://shop.tastycoffee.ru/profile\"]")
    private WebElement profileLink;

    @FindBy(css = "div[class=\"btn-wrapper\"]>a>span[class=\"ic-espresso\"]")
    private WebElement espressoIcon;

    @FindBy(id = "openSearch_h")
    private WebElement openSearchBtn;

    @FindBy(id = "search_h")
    private WebElement inputSearch;


    public MainPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public MainPage openProfileLink(){
        profileLink.click();
        return this;
    }

    public MainPage clickEspressoIcon(){
        espressoIcon.click();
        return this;
    }

    public MainPage clickOpenSearchBtn(){
        openSearchBtn.click();
        return this;
    }

    public MainPage inputSearch(String item){
        Actions action = new Actions(driver);
        action.moveToElement(openSearchBtn);
        action.click(openSearchBtn);
        action.sendKeys(inputSearch,item);
        action.build().perform();
        return this;
    }
}
