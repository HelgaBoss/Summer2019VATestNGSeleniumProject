package com.cybertek.tests.d3WebElementClass;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURLNotChanged {
    public static void main(String[] args) {
      // open chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // go to http://practice
        driver.get("\"http://practice.cybertekschool.com/forgot password");

        // save the expected url
        String expectedURL = driver.getCurrentUrl();

        // click on Retrieve password
        // webElement --> class that represent elements from the webpage
        // findElement --> method used to find elemet on page
        // returns a webElement
        WebElement retrievePassword = driver.findElement(By.id("form_submit"));

        retrievePassword.click();

        //verify taht url did not change
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.equals(expectedURL)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
