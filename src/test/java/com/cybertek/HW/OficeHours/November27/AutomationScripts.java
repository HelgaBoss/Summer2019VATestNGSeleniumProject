package com.cybertek.HW.OficeHours.November27;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AutomationScripts {
    @Test
    public void test1() throws InterruptedException {

        //since RemoteWebDriver is parent class for Chrome,IE,FireFox etc..

        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("http://qa3.vytrack.com/user/login");
        WebElement submitButton = driver.findElement(By.id("_submit"));
        WebElement userName = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));

        driver.executeScript("arguments[0].setAttribute('value', 'storemanager85')", userName);
        driver.executeScript("arguments[0].setAttribute('value', 'UserUser123')", password);

        // arguments[0]= first web element after,( in our case: submitButton
        driver.executeScript("arguments[0].setAttribute('value', 'storemanager85')", userName);
        driver.executeScript("arguments[0].setAttribute('value', 'UserUser123')", password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //arguments[0] = first web element after , (in our case: submitBtn)
        driver.executeScript("arguments[0].click()", submitButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}