import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyProjectTest {

    private static String loginEmail = "lepeniy783@elastit.com";
    private static String password = "lepeniy783";
    private static WebDriver driver;
    private static String itemTitle="Бариста";
    private static String urlDriver="https://shop.tastycoffee.ru/";

    @DisplayName("Entrance")
    @Description("Инициализируем драйвер и входим в аккаунт")
    @BeforeAll
    @Test
    static void InitializeDriver(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("incognito");
        //chromeOptions.addArguments("--headless"); // по какой-то причине тесты с этой опцией падают
        chromeOptions.addArguments("start-maximized");
        //chromeOptions.setPageLoadTimeout(Duration.ofSeconds(12));

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(urlDriver);
        System.out.println("DriverUp");



        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(loginEmail,password);
        System.out.println("LogIn");

        //если ссылка на аккаунт появилась
        Assertions.assertTrue(new MainPage(driver).getOrderHistories()
                .isDisplayed());
        System.out.println("Main Page");
    }
    @DisplayName("To Main Page")
    @Description("Возвращаемся на главную страницу")
    @BeforeEach
    @Test
     void InitMainPage(){
        Assertions.assertDoesNotThrow( () -> driver.navigate().to("https://shop.tastycoffee.ru/"),
                "Страница недоступна");
    }


    @DisplayName("Edit My Account Info Test")
    @Description("Переход в профиль, редактирование данных, сохранение")
    @Story("Измение данных в акааунте")
    @Test
    void editMyAccountInfo(){

        MainPage mainPage=new MainPage(driver);

        mainPage.openProfileLink();

        ProfileMyAccountPage profileMyAccountPage=new ProfileMyAccountPage(driver);

        //если вкладка с личной информацие доступна
        Assertions.assertTrue(profileMyAccountPage.getMyAccountLink()
                .isDisplayed());
        System.out.println("Profile page");

        String str1=profileMyAccountPage.getLegalNameField().getText();
        profileMyAccountPage.inputLegalName().saveUpdates();
        String str2=profileMyAccountPage.getLegalNameField().getText();

        //если изменения сохранились
        Assertions.assertTrue(str1.contentEquals(str2));
        System.out.println("Legal name updated");
    }


    @DisplayName("Basket Control Test")
    @Description("Поиск товара в катологе, добавление в корзину, удаление из корзины")
    @Story("Проверка сценария покупки")
    @Test
    void basketControlTest(){
        MainPage mainPage=new MainPage(driver);

        //если доступна кнопка перехода в каталог
        Assertions.assertTrue(mainPage.getBuyItemBtn()
                .isDisplayed(),"Ссылка на покупку первого лота из списка сорта недели недоступна");
        mainPage.clickEspressoIcon();
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


        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(espressoStorePage.getSupportTriggerFrame()));
        basketPage.deleteItem();

        //для выполнения корзина должна быть пуста
        Assertions.assertTrue(basketPage.getCatalogPage()
                .isDisplayed(),"Корзина не пуста");
        System.out.println("Item deleted");
    }

    @DisplayName("Catalog Searching Test")
    @Description("Открываем строку поиска по сайту, проверяем наличие товара, переходим на страницу товара")
    @Story("Функционал поиска по каталогу")
    @Test
    void searching(){
        MainPage mainPage=new MainPage(driver);

        mainPage.inputSearch(itemTitle); //набираем искомый товар и жмем enter

        //если страница товара доступна
        Assertions.assertTrue(driver.findElement(By.linkText(itemTitle)).isDisplayed(),"страница товара не доступна");
    }

    @DisplayName("Comparing test")
    @Description("Переходим в каталог, добавляем два первыйх товара в сравнение, " +
            "переходим к списку, удалем товары из списка при помощи скрипта")
    @Story("Проверка функции сравнения товаров")
    @Test
    void productComparing(){
        MainPage mainPage=new MainPage(driver);

        //если доступна кнопка перехода в каталог
        Assertions.assertTrue(mainPage.getBuyItemBtn()
                .isDisplayed(),"Ссылка на покупку первого лота из списка сорта недели недоступна");

        mainPage.clickEspressoIcon();
        System.out.println("Espresso page");

        EspressoStorePage espressoStorePage=new EspressoStorePage(driver);


        espressoStorePage.compareItem780().compareItem295();
        System.out.println("compare list complete");

        //если товары добавлены в сравнение
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(espressoStorePage.getSupportTriggerFrame()));
        mainPage.clickCountCompareProductsIcon();
        System.out.println("compare page");




        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('button[onclick=\"deleteCompareColumn(295)\"]',':after').click();");
        js.executeScript("document.querySelector('button[onclick=\"deleteCompareColumn(780)\"]',':after').click();");
        System.out.println("empty compare list");
    }



    @DisplayName("Close driver")
    @Description("закрытие драйвера")
    @AfterAll
    @Test
    static void logIn(){
        driver.quit();
    }



}
