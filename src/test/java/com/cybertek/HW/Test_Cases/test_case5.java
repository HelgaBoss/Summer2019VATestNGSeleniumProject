package com.cybertek.HW.Test_Cases;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_case5 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()= 'Registration Form']")).click();
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("123");

        String actualResult = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
        System.out.println(actualResult);

        Assert.assertTrue(actualResult.equals("The last name can only consist of alphabetical letters and dash"));
    }
}
