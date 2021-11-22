package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class CRMCreateProject {

    public static void createProject(String accountNameUserTest,
                                     String accountPasswordUserTest,
                                     String projectName,
                                     String companyTitleUserTest,
                                     String lastNameUserTest,
                                     String firstNameUserTest) {



        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("incognito");



        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");

        //заходим в учётку
        driver.findElement(By
                        .cssSelector("div[class=input-prepend] > input[name=_username]"))
                .sendKeys(accountNameUserTest);

        driver.findElement(By
                        .cssSelector("input[name=_password][id=prependedInput2]"))
                .sendKeys(accountPasswordUserTest + Keys.ENTER);


        //выбираем кнопку Контакты из выпадющего списка Контрагенты
        Actions openContacts = new Actions(driver);

        WebElement contractors = driver.findElement(By
                .cssSelector("#main-menu > ul > li:nth-child(3) > a > span"));
        openContacts.moveToElement(contractors);

        WebElement contacts = driver.findElement(By
                .cssSelector("li[data-route=\"crm_project_my\"]"));
        openContacts.moveToElement(contacts);

        openContacts.click().build().perform();


        //кликаем кнопку Создать Проект

        WebElement buttonCreateProject = driver.findElement(By
                .cssSelector("div[class=\"pull-left btn-group icons-holder\"]>a[href=\"/project/create/\"]"));
        buttonCreateProject.click();

        //Заполняем форму

        driver.findElement(By
                        .name("crm_project[name]"))
                .sendKeys(projectName);

        driver.findElement(By
                        .cssSelector("div[class=\"company-container\"]>div>a>span[class=\"select2-chosen\"]"))
                .click();


        WebElement companySearchBar = driver.findElement(By
                .cssSelector("#select2-drop > div > input"));
        companySearchBar.sendKeys(companyTitleUserTest);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.cssSelector("span[class=\"select2-match\"]"))));
        companySearchBar.sendKeys(Keys.ENTER);


        driver.findElement(By.name("crm_project[priority]"))
                .sendKeys(Keys.ARROW_UP);

        driver.findElement(By.name("crm_project[financeSource]"))
                .sendKeys(Keys.ARROW_DOWN);

        driver.findElement(By.name("crm_project[businessUnit]"))
                .sendKeys(Keys.ARROW_DOWN);

        driver.findElement(By.name("crm_project[curator]"))
                .sendKeys("Скоробогатова");


        driver.findElement(By.name("crm_project[rp]"))
                .sendKeys("Дедова");

        driver.findElement(By.name("crm_project[administrator]"))
                .sendKeys("Карпова");

        driver.findElement(By.name("crm_project[manager]"))
                .sendKeys("Прохорова");

        WebElement mainContactSearchBar = driver.findElement(By
                .cssSelector("div[class=\"select2-container select2\"]>a>span[class=\"select2-chosen\"]"));
        mainContactSearchBar.click();

        driver.findElement(By
                        .cssSelector("#select2-drop > div > input"))
                .sendKeys(lastNameUserTest+" "+firstNameUserTest+Keys.ENTER);


        driver.findElement(By.cssSelector("button[class=\"btn btn-success action-button\"]")).click();

        driver.quit();

    }

}
