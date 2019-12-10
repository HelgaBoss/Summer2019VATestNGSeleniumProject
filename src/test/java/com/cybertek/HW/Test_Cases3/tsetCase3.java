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

public class tsetCase3 {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");


    }

    @Test
    public void test3() {
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa1.vytrack.com");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        WebElement activitiesElement = driver.findElement(By.xpath("(//span)[27]"));
        WebElement calendarEvents = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(calendarEvents).perform();
        calendarEvents.click();
        String act = driver.findElement(By.xpath("//button[contains(text(),'25')]")).getText();

        Assert.assertEquals(act,"25");
    }

    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
//        driver.quit();
    }
}
