package com.cybertek.tests.d10_Synhronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ExplicitWaitTest {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
//        driver.quit();
    }

    @Test
    public void testWaitForVisible() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        //click on strat
        driver.findElement(By.tagName("button")).click();

        //enter username
//        driver.findElement(By.id("username")).sendKeys("Helga");

        //finding element that is not visible
        WebElement username = driver.findElement(By.id("username"));

        //create explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //actually
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("Luis");



        //click on the elements that is not visible
//        username.sendKeys("Olya(sorry Lokya)");

    }

    @Test
    public void TestToBeEnable() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        driver.findElement(By.cssSelector("button[onclick=‘swapInput()’]")).click();

        WebElement input = driver.findElement(By.cssSelector("input[type=‘text’]"));

        WebDriverWait wait = new WebDriverWait(driver, 10);

        // wait for element to be clickable/enabled
        wait.until(ExpectedConditions.elementToBeClickable(input));
        input.sendKeys("Olegaaaaa");

    }
}