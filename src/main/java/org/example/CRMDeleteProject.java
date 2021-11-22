package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CRMDeleteProject {
    public static void deleteProject(String accountNameUserTest,
                                     String accountPasswordUserTest,
                                     String projectName){


        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("incognito");



        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");

        //заходим в учётку
        driver.findElement(By
                        .cssSelector("div[class=input-prepend] > input[name=_username]"))
                .sendKeys(accountNameUserTest);

        driver.findElement(By
                        .cssSelector("input[name=_password][id=prependedInput2]"))
                .sendKeys(accountPasswordUserTest + Keys.ENTER);
        driver.findElement(By.cssSelector("i[class=\"icon-search\"]")).click();
        driver.findElement(By.id("search-bar-search")).sendKeys(projectName+ Keys.ENTER);

        driver.findElement(By.linkText(projectName)).click();

        driver.findElement(By
                        .cssSelector("a[class=\" btn icons-holder-text no-hash remove-button\"]"))
                .click();

        driver.findElement(By.cssSelector("a[class=\"btn ok btn-primary\"]")).click();

        driver.quit();
    }
}
