package com.cybertek.HW.locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.xpath.XPath;

public class VyTrackShortcutFunction {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        //open browser
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardownMrthod() throws InterruptedException {
        Thread.sleep(2000);
//        driver.quit();
    }

    @Test
     public void salesManager() throws InterruptedException {
        // open login page
        driver.get("https://qa2.vytrack.com/user/login");

        // login as salesmanager
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager119");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);

        //Verify Dashboard page is open
        String expectedUrl = "https://qa2.vytrack.com/";
        String actualResult = driver.getCurrentUrl();

        if(actualResult.equals(expectedUrl)) {
            System.out.println("PASS");
            System.out.println("Dashboard is opened");
        }else {
            System.out.println("FAIL");
        }
        Thread.sleep(3000);
        // click on shortcuts icon
        driver.findElement(By.xpath("//div[@class='dropdown header-dropdown-shortcut header-utility-dropdown']")).click();

        //Click on link See full list
        driver.findElement(By.xpath("//div[@class='extra-small']/a")).click();

        // click in opportunities
        Thread.sleep(3000);
        driver.findElement(By.xpath("//td/a[@href='/opportunity']")).click();
        Thread.sleep(3000);
        String expectedTitle =driver.getTitle();

         if(expectedTitle.equals("Open Opportunities - Opportunities - Sales")) {
             System.out.println("Verify Open opportunities  - PASS");
         } else {
             System.out.println("FAIL");
         }
         Thread.sleep(3000);

        //Click on link See full list
        driver.findElement(By.xpath("//i[@class='fa-share-square']")).click();

        //Click on link See full list
        driver.findElement(By.xpath("//div[@class='extra-small']")).click();

        //Click on link Vehicle Service Logs
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Vehicle Service')]")).click();

        Thread.sleep(3000);
        String error = driver.findElement(By.xpath("//div[@class='message']")).getText();
        if(error.equals("You do not have permission to perform this action.")){
            System.out.println("Verify error message text - PASS");
        } else {
            System.out.println("FAIL");
        }

       String title =  driver.getTitle();
        if(title.equals("Shortcut Actions List")){
            System.out.println("page is still open - PASS");
        }else {
            System.out.println("FAIL");
        }







    }
}
