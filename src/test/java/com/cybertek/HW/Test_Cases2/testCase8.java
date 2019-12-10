package com.cybertek.HW.Test_Cases2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testCase8 {
    WebDriver driver;

    @BeforeMethod
    public void setupmethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void t() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Test
    public void test() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Autocomplete']")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        String actualMessase = driver.findElement(By.id("result")).getText();
        String expectedMessage = "You selected: United States of America";
        Assert.assertEquals(actualMessase,expectedMessage);


    }
}
