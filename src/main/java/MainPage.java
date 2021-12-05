import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(css = "a[href=\"https://shop.tastycoffee.ru/profile\"]")
    private WebElement profileLink;

    @FindBy(css = "div[class=\"btn-wrapper\"]>a>span[class=\"ic-espresso\"]")
    private WebElement espressoIcon;

    public WebElement getEspressoIcon() {
        return espressoIcon;
    }

    @FindBy(id = "openSearch_h")
    private WebElement openSearchBtn;

    @FindBy(id = "search_h")
    private WebElement inputSearch;

    @FindBy(css = "a[href=\"https://shop.tastycoffee.ru/order-histories\"]")
    private WebElement orderHistories;

    public WebElement getOrderHistories() {
        return orderHistories;
    }

    @FindBy(css = "div[class=\"owl-carousel card-wrap two\"]>div:first-child>form>div[class=\"absCard\"]>div>div>a")
    private WebElement buyItemBtn;

    public WebElement getBuyItemBtn() {
        return buyItemBtn;
    }

    @FindBy(id = "countCompareProducts")
    private WebElement countCompareProductsIcon;

    public WebElement getCountCompareProductsIcon() {
        return countCompareProductsIcon;
    }

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
        action.sendKeys(inputSearch,item+ Keys.ENTER);
        action.build().perform();
        return this;
    }
    public MainPage clickCountCompareProductsIcon(){
        Actions action = new Actions(driver);
        action.moveToElement(countCompareProductsIcon);
        action.click(countCompareProductsIcon);
        action.build().perform();
        return this;
    }

}
