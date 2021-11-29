import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyProjectTest {

    private static String loginEmail = "lepeniy783@elastit.com";
    private static String password = "lepeniy783";
    private static WebDriver driver;
    private static String itemTitle="Бариста";

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

        //если ссылка на аккаунт появилась
        Assertions.assertTrue(driver.findElement(By
                .cssSelector("a[href=\"https://shop.tastycoffee.ru/order-histories\"]"))
                .isDisplayed());
        System.out.println("Main Page");
    }

    @DisplayName("Edit My Account Info Test")
    @Test
    void editMyAccountInfo(){

        MainPage mainPage=new MainPage(driver);

        mainPage.openProfileLink();

        //если вкладка с личной информацие доступна
        Assertions.assertTrue(driver.findElement(By
                        .cssSelector("a[href=\"https://shop.tastycoffee.ru/my-account\"]"))
                .isDisplayed());
        System.out.println("Profile page");




        ProfileMyAccountPage profileMyAccountPage=new ProfileMyAccountPage(driver);

        String str1=profileMyAccountPage.getLegalNameField().getText();
        profileMyAccountPage.inputLegalName().saveUpdates();
        String str2=profileMyAccountPage.getLegalNameField().getText();

        //если изменения сохранились
        Assertions.assertTrue(str1.contentEquals(str2));
        System.out.println("Legal name updated");
    }


    @DisplayName("Basket Control Test")
    @Test
    void basketControlTest(){
        MainPage mainPage=new MainPage(driver);

        mainPage.clickEspressoIcon();


        //если доступна кнопка перехода в каталог
        Assertions.assertTrue(driver.findElement(By.cssSelector("a[class=\"buyBtn \"]"))
                .isDisplayed(),"Ссылка на каталог эспрессо с главной страницы не доступна");
        System.out.println("Espresso page");


        EspressoStorePage espressoStorePage=new EspressoStorePage(driver);

        espressoStorePage.purchaseRandomItemAndRefresh();

        //если перезагрузка страницы завершена
        Assertions.assertTrue(espressoStorePage.getSupportTriggerFrame()
                .isDisplayed(),"покупка совершена");
        System.out.println("Purchase done");

        //EspressoStorePage espressoStorePage=new EspressoStorePage(driver);

        espressoStorePage.goToBasket();

        //если перешли на страницу корзины
        Assertions.assertTrue(espressoStorePage.getSupportTriggerFrame()
                .isDisplayed(),"Переход в корзину не совершен");
        System.out.println("Basket page");

        BasketPage basketPage=new BasketPage(driver);

        basketPage.deleteItem();

        //если корзина пуста
        Assertions.assertTrue(basketPage.getCatalogPage()
                .isDisplayed(),"Корзина не пуста");
        System.out.println("Item deleted");
    }

    @DisplayName("Catalog Searching Test")
    @Test
    void searching(){
        MainPage mainPage=new MainPage(driver);

        mainPage.inputSearch(itemTitle);

        //если искомый элемент есть в списке
        WebElement itemElement=driver.findElement(By.linkText(itemTitle));
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(itemElement));
        Assertions.assertTrue(itemElement.isDisplayed(),"искомого товара нет в списке");

        itemElement.click();

        //если страница товара доступна
        Assertions.assertTrue(driver.findElement(By.linkText(itemTitle)).isDisplayed(),"страница товара не доступна");
    }

    @DisplayName("Сравнение Продуктов")
    @Test
    void productComparing(){
        MainPage mainPage=new MainPage(driver);

        mainPage.clickEspressoIcon();


        //если доступна кнопка перехода в каталог
        Assertions.assertTrue(driver.findElement(By.cssSelector("a[class=\"buyBtn \"]"))
                .isDisplayed(),"Ссылка на каталог эспрессо с главной страницы не доступна");
        System.out.println("Espresso page");

        EspressoStorePage espressoStorePage=new EspressoStorePage(driver);


        espressoStorePage.compareItem780().compareItem295();
        System.out.println("compare list complete");

        //если товары добавлены в сравнение
        WebElement productsCountCompare=driver.findElement(By.id("countCompareProducts"));
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(productsCountCompare));
        Assertions.assertTrue(productsCountCompare.isDisplayed());
        espressoStorePage.clickCompare();
        System.out.println("compare page");



        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('button[onclick=\"deleteCompareColumn(295)\"]',':after').click();");
        js.executeScript("document.querySelector('button[onclick=\"deleteCompareColumn(780)\"]',':after').click();");
        System.out.println("empty compare list");
    }



    @DisplayName("Close driver")
    @AfterAll
    @Test
    static void logIn(){
        driver.quit();
    }



}
