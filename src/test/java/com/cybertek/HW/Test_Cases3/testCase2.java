package com.cybertek.HW.Test_Cases3;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testCase2 {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void trowdow() throws InterruptedException {
        Thread.sleep(1000);
//        driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://qa1.vytrack.com");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        WebElement activitiesElement = driver.findElement(By.xpath("(//span)[27]"));
        WebElement calendarEvents = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(calendarEvents).perform();
        calendarEvents.click();

        String act = driver.findElement(By.xpath("//input[@value='1']")).getAttribute("value");
        String ecx = "1";
        Assert.assertEquals(act,ecx);
    }
}
