package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class EditProfile {

    public static void edit(String logIn, String password){

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

        driver.findElement(By.cssSelector("a[href=\"https://shop.tastycoffee.ru/profile\"]")).click();
        System.out.println("Profile page");

        driver.findElement(By.cssSelector("a[href=\"https://shop.tastycoffee.ru/my-account\"]")).click();
        System.out.println("my-account");

        driver.findElement(By.cssSelector("input[name=\"legal_name\"]"))
                .sendKeys("1");
        System.out.println("add 1 to legal name");

        driver.findElement(By.id("submit-update-account")).click();
        System.out.println("saved");


        driver.quit();

    }
}
