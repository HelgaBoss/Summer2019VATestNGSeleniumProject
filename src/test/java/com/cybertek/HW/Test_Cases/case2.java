package com.cybertek.HW.Test_Cases;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class case2 {
    WebDriver driver;


@BeforeMethod
  public void setupmethod() {
     driver = WebDriverFactory.getDriver("chrome");
    driver.get("https://practice-cybertekschool.herokuapp.com");
   }

   @AfterMethod
      public void teardownMethod() throws InterruptedException {
    Thread.sleep(2000);
//    driver.quit();
   }

   @Test
   public void testCase2() {
       List<WebElement> examples = driver.findElements(By.tagName("li"));
       int size = examples.size()-1;
       System.out.println(size);



   }

}
