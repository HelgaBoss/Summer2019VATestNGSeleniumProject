package com.cybertek.HW.Test_Cases3;

import com.cybertek.HW.OficeHours.November27.Action;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testCase1 {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setupmethod() {
        driver= WebDriverFactory.getDriver("chrome");

    }
    @Test
    public void test1() {

        // TODO OPEN BROWSER
        driver = WebDriverFactory.getDriver("chrome");
        //explicit wait
        wait =  new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser
        driver.manage().window().maximize();
        actions = new Actions(driver);


        // TODO LOGIN
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        // TODO CHANGE MENU
        WebElement activitiesElement = driver.findElement(By.xpath("(//span)[27]"));
        WebElement calendarEvents = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(calendarEvents).perform();
        calendarEvents.click();
        WebElement option = driver.findElement(By.xpath("//div[@href ='#']"));
        Assert.assertTrue(option.isDisplayed());



    }



    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
//        driver.quit();
    }

}
