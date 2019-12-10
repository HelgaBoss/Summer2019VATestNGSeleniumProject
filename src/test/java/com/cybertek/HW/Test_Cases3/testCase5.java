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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class testCase5 {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setupmethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
//        driver.quit();
    }
    @Test
    public void test5() throws InterruptedException {

        wait= new WebDriverWait(driver,10);
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("https://qa1.vytrack.com");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        WebElement activitiesElement = driver.findElement(By.xpath("(//span)[27]"));
        WebElement calendarEvents = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(calendarEvents).perform();
        calendarEvents.click();

        // 4. Click on the top checkbox to select all
        Thread.sleep(2000);
        WebElement checkBox = driver.findElement(By.xpath("//thead[@class='grid-header']/tr/th/div/button/input"));
        checkBox.click();

        // 5. Verify that all calendar events were selected
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@tabindex='-1']"));
        System.out.println(checkboxes.size());

        int count = 0;
        for(WebElement each : checkboxes) {
            boolean b = each.isSelected();
            count++;
            System.out.println(count+". line is clicked :"+ b);
            }
        }



    }


