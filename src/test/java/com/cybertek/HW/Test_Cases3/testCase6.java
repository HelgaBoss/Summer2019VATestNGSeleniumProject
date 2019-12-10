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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class testCase6 {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void trowdown() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Test
    public void test6() throws InterruptedException {

        wait = new WebDriverWait(driver,10);
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //1. Go to “https://qa1.vytrack.com/"
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/user/login");

        //2. Login as a store manager
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        //3. Navigate to “Activities -> Calendar Events”
        WebElement activitiesElement = driver.findElement(By.xpath("(//span)[27]"));
        WebElement calendarEvents = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(calendarEvents).perform();
        calendarEvents.click();

        //4. Select “Testers meeting”
        Thread.sleep(3000);
        WebElement e = driver.findElement(By.xpath("//table//tbody//tr[13]//td[text()='Testers Meeting']"));
        e.click();
        String a = e.getText();


        //5. Verify that following data is displayed:
        Assert.assertTrue(e.isDisplayed());


    }
}
