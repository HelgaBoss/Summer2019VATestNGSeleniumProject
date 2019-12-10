package com.cybertek.HW.Test_Cases;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testCase7 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @Test
    public void test() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()= 'Registration Form']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testers@email");
       String actualResult= driver.findElement(By.xpath("//small[@data-bv-validator='emailAddress']")).getText();
       String actualResult2 = driver.findElement(By.xpath("//small[text()= 'Email format is not correct']")).getText();

        Assert.assertTrue(actualResult.equals("email address is not a valid"));
        Assert.assertTrue(actualResult2.equals("Email format is not correct"));
        System.out.println(actualResult);
        System.out.println(actualResult2);

    }
}
