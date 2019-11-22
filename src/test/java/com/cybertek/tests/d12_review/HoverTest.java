package com.cybertek.tests.d12_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest {

    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        actions= new Actions(driver);
        driver.get("https://practice-cybertekschool.herokuapp.com/hovers");
    }

    @Test
    public void test() {
        for (int i =0; i < 3; i++) {
            System.out.println(i);

           WebElement image =  driver.findElement(By.tagName("img"));
           actions.moveToElement(image).perform();
           //this is bu calling thread.sleep
           actions.pause(2000);
           String xpath = "//h5[.='name: user"+(i+1)+"']";
            System.out.println(xpath);
           WebElement text = driver.findElement(By.xpath(xpath));

            System.out.println("Verify element "+i);
//            Assert.assertTrue(text.isDisplayed());
        }
    }
}
