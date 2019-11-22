package com.cybertek.tests.d11_file_upload_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionsExamplesTest {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
//        driver.quit();
    }

    @Test
    public void hoverTset() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        // Actions --> class that contains all the user interactions
        Actions actions = new Actions(driver);
        Thread.sleep(2000);

        //moveToElement() --> move to mouse on top of the given element
        // perfom()--> complete the action
        actions.moveToElement(img1).perform();

        Assert.assertTrue(driver.findElement(By.linkText("View profile")).isDisplayed());
    }

    @Test
    public void dragdropTest() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //source --> we will drag this element
        WebElement source = driver.findElement(By.id("draggable"));
        //target--> we drop here
        WebElement target = driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        // dragAndDrop --> drags the source to target
        actions.dragAndDrop(source,target).perform();
    }

    @Test
    public void dragdropbychaingtest() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //source --> we will drag this element
        WebElement source = driver.findElement(By.id("draggable"));
        //target--> we drop here
        WebElement target = driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);

        Thread.sleep(3000);
        //we can chain multiple actions
        //at the end call the build().perform()
        actions.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();

    }
}
