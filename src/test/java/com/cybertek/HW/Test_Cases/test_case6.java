package com.cybertek.HW.Test_Cases;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_case6 {
    WebDriver driver;
     @BeforeMethod
    public void setupMethod() {
         driver = WebDriverFactory.getDriver("chrome");
     }
     @AfterMethod
    public void teardownMethod() throws InterruptedException {
         Thread.sleep(2000);
     }
     @Test
    public void test() {
         driver.get("https://practice-cybertekschool.herokuapp.com/");
         //Click on “Registration Form”
         driver.findElement(By.xpath("//a[text()= 'Registration Form']")).click();
         driver.findElement(By.xpath("//input[@name='username']")).sendKeys("user");
         String actualresult = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
         Assert.assertTrue(actualresult.equals("The username must be more than 6 and less than 30 characters long"));
     }
}
