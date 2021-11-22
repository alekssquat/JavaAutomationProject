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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Purchase {
    public static void purchase(String logIn, String password){


        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("incognito");



        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://shop.tastycoffee.ru/");

        //заходим в учётку

        WebElement Entrance = driver.findElement(By.cssSelector("button[class=\"greyLink enterOpen\"]"));
        Entrance.click();

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(logIn);

        WebElement pswd = driver.findElement(By.id("password"));
        pswd.sendKeys(password+ Keys.ENTER);

        driver.findElement(By.cssSelector("div[class=\"btn-wrapper\"]>a>span[class=\"ic-espresso\"]")).click();
        System.out.println("espresso shop");

        new WebDriverWait(driver,6)
                .until(ExpectedConditions.elementToBeClickable
                        (By.cssSelector("a[class=\"buyBtn \"]")));

        driver.findElement(By.cssSelector("a[class=\"buyBtn \"]")).click();
        System.out.println("buy");

        driver.navigate().refresh();

        new WebDriverWait(driver,6)
                .until(ExpectedConditions.elementToBeClickable
                        (By.cssSelector("span[class=\"text trigger-font-family\"]")));
        System.out.println("assist available");

        driver.findElement(By.cssSelector("span[id=\"header_cart_text\"]>div[class=\"greyText\"]")).click();
        System.out.println("in basket");

        driver.findElement(By.cssSelector("div[class=\"goods__price\"]>a")).click();
        System.out.println("item deleted");








        driver.quit();

    }
}
