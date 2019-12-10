package com.cybertek.HW.Test_Cases;

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
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @Test
    public void test() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Click on “Registration Form”
        driver.findElement(By.xpath("//a[text()= 'Registration Form']")).click();
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("5711234354");
       String error =  driver.findElement(By.xpath("//small[text()= 'Phone format is not correct']")).getText();
        Assert.assertTrue(error.equals("Phone format is not correct"));
        System.out.println(error);



    }
}
