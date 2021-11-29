import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {
    private WebDriver driver;

    @FindBy(css = "div[class=\"goods__price\"]>a")
    private WebElement deleteBtn;

    public WebElement getDeleteBtn() {
        return deleteBtn;
    }

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public BasketPage deleteItem(){
        deleteBtn.click();
        return this;
    }
}
