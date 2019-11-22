package com.cybertek.HW.locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleResult {
    public static void main(String[] args) throws InterruptedException {


        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://google.com");
        WebElement search = driver.findElement(By.name("q"));
        List<String> searchStr = Arrays.asList("Java", "JUnit", "Selenium");
        search.sendKeys(searchStr.get(0));
        search.submit();
        WebElement url = driver.findElement(By.className("iUh30"));
        String saveUrl = url.getText();
//        System.out.println(saveUrl);

        WebElement link = driver.findElement(By.className("S3Uucc"));
        link.click();

        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(saveUrl)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Actaul result: " + actualUrl);
            System.out.println("Expected result: " + saveUrl);
        }
        driver.navigate().back();

        Thread.sleep(2000);


        driver.get("https://google.com");
        search = driver.findElement(By.name("q"));
        search.sendKeys(searchStr.get(1));
        search.submit();
//        WebElement url1 = driver1.findElement(By.className("iUh30 bc rpCHfe"));
        url = driver.findElement(By.className("iUh30"));
        saveUrl = url.getText();

        link = driver.findElement(By.className("S3Uucc"));
        link.click();

        actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(saveUrl)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Actaul result: " + actualUrl);
            System.out.println("Expected result: " + saveUrl);
        }
        driver.navigate().back();

        Thread.sleep(2000);

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://google.com");

        search = driver.findElement(By.name("q"));
        search.sendKeys(searchStr.get(2));
        search.submit();

        url = driver.findElement(By.className("iUh30"));
        saveUrl = url.getText();

        link = driver.findElement(By.className("S3Uucc"));
        link.click();

        actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(saveUrl)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Actaul result: " + actualUrl);
            System.out.println("Expected result: " + saveUrl);
        }
    }
}
