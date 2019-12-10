package com.cybertek.HW.Test_Cases;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_case4 {
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
        //Click on “Registration Form”

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath(" //a[text()= 'Registration Form']")).click();
       // Enter “123” into first name input box.
        driver.findElement(By.xpath("//input[@placeholder='first name']")).sendKeys("123");
        Thread.sleep(1000);
        String actualResult = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
        //Verify that warning message is displayed:
        Assert.assertTrue(actualResult.equals("first name can only consist of alphabetical letters"));

    }
}
