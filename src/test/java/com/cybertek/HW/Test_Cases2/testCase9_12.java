package com.cybertek.HW.Test_Cases2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testCase9_12 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    public void test9() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()= 'Status Codes']")).click();
        driver.findElement(By.xpath("//a[text()='200']")).click();
        String actualMess = driver.findElement(By.xpath("//p[contains(text(),'This page returned a 200 status code')]")).getText();
        String expectedMess = "This page returned a 200 status code.";
        Assert.assertTrue(actualMess.contains(expectedMess));


    }

    @Test
    public void test10() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//a[text()='301']")).click();
        String actualMess = driver.findElement(By.xpath("//p[contains(text(),'This page returned a 301 status code')]")).getText();
        String expectedMess = "This page returned a 301 status code.";
        Assert.assertTrue(actualMess.contains(expectedMess));

    }

    @Test
    public void test11() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//a[text()='404']")).click();
        String actualMess = driver.findElement(By.xpath("//p[contains(text(),'This page returned a 404 status code')]")).getText();
        String expectedMess = "This page returned a 404 status code.";
        Assert.assertTrue(actualMess.contains(expectedMess));
    }

    @Test
    public void test12() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Status Codes']")).click();
        driver.findElement(By.xpath("//a[text()='500']")).click();
        String actualMess = driver.findElement(By.xpath("//p[contains(text(),'This page returned a 500 status code')]")).getText();
        String expectedMess = "This page returned a 500 status code.";
        Assert.assertTrue(actualMess.contains(expectedMess));

    }
}
