import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class EditProfileTest {
    private static String loginEmail = "lepeniy783@elastit.com";
    private static String password = "lepeniy783";
    private static WebDriver driver;

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

    @DisplayName("Open Profile Page")
    @Test
    void openProfile(){
        MainPage mainPage=new MainPage(driver);

        mainPage.openProfileLink();

        Assertions.assertTrue(driver.findElement(By
                .cssSelector("a[href=\"https://shop.tastycoffee.ru/my-account\"]"))
                .isDisplayed());
        System.out.println("Profile page");

        class InnerClass{
            @DisplayName("Edit Legal Name")
            @Test
            void openMyAccountPage(){
                ProfileMyAccountPage profileMyAccountPage=new ProfileMyAccountPage(driver);

                String str1=profileMyAccountPage.getLegalNameField().getText();
                profileMyAccountPage.inputLegalName().saveUpdates();
                String str2=profileMyAccountPage.getLegalNameField().getText();

                Assertions.assertTrue(str1.contentEquals(str2));
                System.out.println("Legal name updated");
            }
        }
    }



    @DisplayName("Close driver")
    @AfterAll
    @Test
    static void logIn(){
        driver.quit();
    }



}
