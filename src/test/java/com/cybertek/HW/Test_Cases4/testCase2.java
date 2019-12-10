package com.cybertek.HW.Test_Cases4;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

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
//        WebElement allOptions = driver.findElement(By.xpath("//tbody[@class='ui-sortable']"));
        Thread.sleep(1000);

//        actions.moveToElement(allOptions).perform();
        ArrayList<WebElement>deselect = new ArrayList<>();
        for(int i = 2; i <= 7; i++) {
            String actualXpath = "//tbody/tr["+ i +"]/td/label";
            Thread.sleep(1000);


        }


    }
    }


