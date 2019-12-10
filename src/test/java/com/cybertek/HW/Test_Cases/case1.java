package com.cybertek.HW.Test_Cases;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class case1 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(3000);

    }

    @Test
    public void test1() {
        driver.get("https://practice-cybertekschool.herokuapp.com");

        // Click on “Sign Up For Mailing List”
        driver.findElement(By.xpath("//li/a[.='Sign Up For Mailing List']")).click();
        // Enter any valid name
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("OLYALYALYA");
        //Enter any valid email
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("olya@gmail.com");
       // Click on “Sign Up” button
        driver.findElement(By.className("radius")).click();
        WebElement expectedResult = driver.findElement(By.className("subheader"));
        WebElement button = driver.findElement(By.className("nav-link"));


        Assert.assertTrue(expectedResult.isDisplayed());
        Assert.assertTrue(button.isDisplayed());
        //Thank you for signing up. Click the button below to return to the home page.
        System.out.println(expectedResult.getText());
    }
}
