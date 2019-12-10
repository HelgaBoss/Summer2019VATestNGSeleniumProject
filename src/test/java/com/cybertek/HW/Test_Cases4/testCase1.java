package com.cybertek.HW.Test_Cases4;

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
import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

public class testCase1 {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        //explicit wait
//        wait = new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        WebElement activities = driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[5]/a/span"));
        WebElement calendarEvents = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
//        Thread.sleep(2000);
        actions.moveToElement(calendarEvents).perform();
        calendarEvents.click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void Test01() throws InterruptedException {
        WebElement threeDots = driver.findElement(By.xpath("//table/tbody/tr[14]/td[9]"));
        Thread.sleep(1000);
        actions.moveToElement(threeDots).perform();
        ArrayList<WebElement> threeElement = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String actualXpath = "/html/body/ul/li/ul/li[" + i + "]/a/i";
            WebElement element = driver.findElement(By.xpath(actualXpath));
            Assert.assertTrue(element.isDisplayed());
            element.getAttribute("value");
            threeElement.add(element);
        }
        System.out.println(threeElement);
    }
    }
