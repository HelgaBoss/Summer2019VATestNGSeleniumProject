package com.cybertek.tests.d4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkTextTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //linkText
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link = driver.findElement(By.linkText("example 6: loading overlay that disappears and disappears again"));
        System.out.println(link.getText());

        WebElement cbt = driver.findElement(By.linkText("Cybertek School"));
        System.out.println(cbt.getText());

        //partial link text
        WebElement link6again = driver.findElement(By.partialLinkText("Example 6"));
        System.out.println(link6again.getText());
    }
}
