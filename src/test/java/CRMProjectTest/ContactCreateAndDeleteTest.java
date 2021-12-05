package CRMProjectTest;

import CRMProject.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ContactCreateAndDeleteTest {
    //на данный момент 29.11 CRM недостпуна, пришлось переписывать в слепую

    private static String urlDriver = "https://crm.geekbrains.space/user/login";
    private static String accountNameUserTest = "Applanatest1";
    private static String accountPasswordUserTest = "Student2020!";
    private static WebDriver driver;

    String projectName = "SeleniumWebDriverTest";
    String companyTitleUserTest = "GeekBrains1";
    String curator = "Скоробогатова";
    String rp = "Дедова";
    String administrator = "Карпова";
    String manager = "Прохорова";
    String firstNameUserTest = "James";
    String lastNameUserTest = "Bond";
    String jobTitleUserTest = "Agent";
    String status = "T";


    @DisplayName("Entrance")
    @BeforeAll
    @Test
    static void InitializeDriver(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("incognito");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(urlDriver);
        System.out.println("DriverUp");

        new LoginPage(driver).logIn(accountNameUserTest,accountPasswordUserTest);
        System.out.println("LogIn");

        //если появилась панель навигации
        Assertions.assertTrue(new NavigationBar(driver)
                .getContactUL()
                .isDisplayed());
        System.out.println("Main Page");
    }

    @DisplayName("Create and delete new contact")
    @Test
    void newContactTest(){

        new NavigationBar(driver).openContacts();
        //кликаем кнопку Создать Контактное лицо
        new ContactsPage(driver).clickCreateContact();

        //Заполняем форму

        new NewContactForm(driver)
                .setLastNameInput(lastNameUserTest)
                .setFirstNameInput(firstNameUserTest)
                .setCompanyTitle(companyTitleUserTest)
                .setJobTitle(jobTitleUserTest).setStatus(status);

    }


    @DisplayName("Close driver")
    @AfterAll
    @Test
    static void logIn(){
        driver.quit();
    }


}
