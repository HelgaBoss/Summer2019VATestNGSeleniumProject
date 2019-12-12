package com.cybertek.HW.Test_Cases4;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class testCase2 {
    WebDriverWait wait;
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        Thread.sleep(2000);


        // 2. Login as a store manager
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        //explicit wait
        wait = new WebDriverWait(driver,10);

        // 3. Navigate to “Activities -> Calendar Events”
        actions = new Actions(driver);
        WebElement activities = driver.findElement(By.xpath("(//span)[27]"));
        WebElement calendarEvents = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        Thread.sleep(2000);
        actions.moveToElement(calendarEvents).perform();
        calendarEvents.click();
        }

    @Test
    public void test2() throws InterruptedException {

        // 4. Click on “Grid Options” button
        WebElement gridOptions = driver.findElement(By.xpath("//a[@title ='Grid Settings']"));
        gridOptions.isSelected();
        // 5. Deselect all options except “Title”
        Thread.sleep(1000);
//        actions.moveToElement(allOptions).perform();
        List<WebElement> titles = driver.findElements(By.xpath("//tbody[@class='ui-sortable']/tr/td[@class='title-cell']"));
        List<WebElement> boxes = driver.findElements(By.xpath("//tbody[@class='ui-sortable']/tr/td[@class='visibility-cell']"));
        for (int i = 0; i < titles.size(); i++) {
        if(!titles.get(i).getText().equals("Title")){
            boxes.get(i).click();
        }
        else{
            WebElement titlebox = driver.findElement(By.xpath("(//input[contains(@id,'column')])[1]"));
            Assert.assertTrue(titlebox.isSelected());
        }
    }
    WebElement titlebox = driver.findElement(By.xpath("(//input[contains(@id,'column')])[1]"));
        Assert.assertTrue(titlebox.isSelected());
    }



    }



