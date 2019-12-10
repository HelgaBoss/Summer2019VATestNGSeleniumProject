package com.cybertek.HW.Test_Cases;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class case3 {
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
    public void test() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()= 'Multiple Buttons']")).click();
        driver.findElement(By.xpath("//button[@onclick='button1()']")).click();
        String actualMessage = driver.findElement(By.id("result")).getText();
        String expectedMessage = "Clicked on button one!";
        Assert.assertTrue(actualMessage.equals(expectedMessage));
    }

}
