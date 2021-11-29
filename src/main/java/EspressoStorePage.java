import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(css = "span[id=\"header_cart_text\"]>div[class=\"greyText\"]")
    private WebElement basketLink;

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

}
