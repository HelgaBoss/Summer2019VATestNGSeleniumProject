package com.cybertek.tests.d3WebElementClass;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLChanged {
    public static void main(String[] args) {
        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInput = driver.findElement(By.name("email"));

        //sendKeys --> enters given text
        emailInput.sendKeys("admiralkunkka@email.com");

        //click on Retrieve password
        WebElement retrivePassword = driver.findElement(By.id("form submit"));
        retrivePassword.click();

        String expected = "http://practice.cybertekschool.com/email_sent";
        String actual = driver.getCurrentUrl();

        if(expected.equals(actual)){
            System.out.println("PASS");
        } else{
            System.out.println("FAIL");

            // close the browser
            driver.quit();
        }
    }
}
