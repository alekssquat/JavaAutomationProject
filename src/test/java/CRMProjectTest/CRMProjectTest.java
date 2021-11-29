package CRMProjectTest;

import CRMProject.LoginPage;
import CRMProject.MyProjectPage;
import CRMProject.NavigationBar;
import CRMProject.NewProjectFormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CRMProjectTest {

    //на данный момент 29.11 CRM недостпуна, пришлось переписывать в слепую

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


    @DisplayName("Entrance")
    @BeforeAll
    @Test
    static void InitializeDriver(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("incognito");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        System.out.println("DriverUp");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(accountNameUserTest,accountPasswordUserTest);
        System.out.println("LogIn");

        //если появилась панель навигации
        Assertions.assertTrue(driver.findElement(By
                        .cssSelector("\"#main-menu > ul > li:nth-child(3) > a > span\""))
                .isDisplayed());
        System.out.println("Main Page");
    }

    @DisplayName("Create and delete new project")
    @Test
    void newProjectTest(){

        new NavigationBar(driver).openContacts();
        System.out.println("in my projects page");

        new MyProjectPage(driver).clickNewProjectBtn();
        System.out.println("in new project form");

        NewProjectFormPage newProjectFormPage=new NewProjectFormPage(driver);
        newProjectFormPage.setProjectNameField(projectName)
                .setCompanyList(companyTitleUserTest)
                .setPriorityList()
                .setFinanceSource()
                .setBusinessUnit()
                .setCurator(curator)
                .setRp(rp)
                .setAdministrator(administrator)
                .setManager(manager)
                .setMainContactSearchBar(lastNameUserTest,firstNameUserTest)
                .clickSaveProjectBtn();
        System.out.println("project saved");

        new NavigationBar(driver).searchProjectByName(projectName);
        System.out.println("project deleted");
    }


    @DisplayName("Close driver")
    @AfterAll
    @Test
    static void logIn(){
        driver.quit();
    }
}
