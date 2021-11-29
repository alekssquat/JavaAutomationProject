import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PurchaseTest {
    private static String loginEmail = "lepeniy783@elastit.com";
    private static String password = "lepeniy783";
    private static WebDriver driver;

    //Для сохранения атомарности тестов, решил собрать тестовые функции по пользовательским сценариям
    /*
    @DisplayName("Entrance")
    @BeforeAll
    @Test
    static void InitializeDriver(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("incognito");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shop.tastycoffee.ru/");
        System.out.println("DriverUp");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(loginEmail,password);
        System.out.println("LogIn");

        Assertions.assertTrue(driver.findElement(By
                        .cssSelector("a[href=\"https://shop.tastycoffee.ru/order-histories\"]"))
                .isDisplayed());
        System.out.println("Main Page");
    }


    @DisplayName("Open Espresso Page")
    @Test
    @Order(1)
    void openProfile(){
        MainPage mainPage=new MainPage(driver);

        mainPage.clickEspressoIcon();

        Assertions.assertTrue(driver.findElement(By.cssSelector("a[class=\"buyBtn \"]"))
                .isDisplayed());
        System.out.println("Espresso page");

    }

    @DisplayName("Purchase Random Item And Refresh")
    @Test
    @Order(2)
    void purchaseRandomItemAndRefresh(){
        EspressoStorePage espressoStorePage=new EspressoStorePage(driver);

        espressoStorePage.purchaseRandomItemAndRefresh();

        Assertions.assertTrue(espressoStorePage.getSupportTriggerFrame()
                .isDisplayed());
        System.out.println("Purchase done");
    }

    @DisplayName("Check the basket")
    @Test
    @Order(3)
    void checkTheBasket(){
        EspressoStorePage espressoStorePage=new EspressoStorePage(driver);

        espressoStorePage.goToBasket();

        Assertions.assertTrue(espressoStorePage.getSupportTriggerFrame()
                .isDisplayed());
        System.out.println("Basket page");
    }

    @DisplayName("Delete Item")
    @Test
    @Order(4)
    void deleteItem(){
        BasketPage basketPage=new BasketPage(driver);

        basketPage.deleteItem();

        Assertions.assertTrue(basketPage.getDeleteBtn()
                .isDisplayed());
        System.out.println("Item deleted");
    }


    @DisplayName("Close driver")
    @AfterAll
    @Test
    static void logIn(){

        driver.quit();
        System.out.println("Driver closed");
    }

     */
}
