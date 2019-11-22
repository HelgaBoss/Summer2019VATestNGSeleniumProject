package com.cybertek.tests.o2_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class practices {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.youtube.com");

        String youtube = driver.getTitle();
        System.out.println(youtube);

//        ArrayList<WebElement> names = new ArrayList<>();
       WebElement link = driver.findElement(By.id("search"));
       link.sendKeys("buzova");
      WebElement  link1 = driver.findElement(By.xpath("style-scope ytd-searchbox"));
        link1.click();
    }
}
