import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EspressoStorePage {
    private WebDriver driver;

    @FindBy(css = "a[class=\"buyBtn \"]")
    private WebElement purchaseRandomItem;

    public WebElement getPurchaseRandomItem() {
        return purchaseRandomItem;
    }

    @FindBy(css = "div[id=\"supportTrigger\"]>div>span[class=\"text trigger-font-family\"]")
    private WebElement supportTriggerFrame;

    public WebElement getSupportTriggerFrame() {
        return supportTriggerFrame;
    }

    @FindBy(css = "input[value=\"780\"]")
    private WebElement item780Frame; //НАТТИ

    @FindBy(css = "a[data-product-id=\"780\"]")
    private WebElement item780CompareBtn; //НАТТИ

    @FindBy(css = "input[value=\"780\"]")
    private WebElement item295Frame; //БРАЗЛИЯ СЕРРАДО

    @FindBy(css = "a[data-product-id=\"295\"]")
    private WebElement item295CompareBtn; //БРАЗЛИЯ СЕРРАДО



    @FindBy(css = "span[id=\"header_cart_text\"]>div[class=\"greyText\"]")
    private WebElement basketLink;

    @FindBy(css = "a[ href=\"https://shop.tastycoffee.ru/compare\"]")
    private WebElement compareLink;


    public EspressoStorePage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public EspressoStorePage purchaseRandomItemAndRefresh(){
        purchaseRandomItem.click();
        driver.navigate().refresh();
        return this;
    }

    public EspressoStorePage goToBasket(){
        basketLink.click();
        return this;
    }

    public EspressoStorePage compareItem780(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('a[data-product-id=\"780\"]',':before').click();");

        return this;
    }

    public EspressoStorePage compareItem295(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('a[data-product-id=\"295\"]',':before').click();");
        return this;
    }

    public EspressoStorePage clickCompare(){
        compareLink.click();
        return this;
    }



}
