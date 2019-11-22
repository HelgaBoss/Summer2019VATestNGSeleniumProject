package com.cybertek.HW.locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrack1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");

        WebElement userName = driver.findElement(By.id("prependedInput"));
        String  email = "user21",
                password = "UserUser123";
        userName.sendKeys(email);


        WebElement userPassword = driver.findElement(By.id("prependedInput2"));
        userPassword.sendKeys(password);
        userPassword.submit();

        Thread.sleep(3000);
        WebElement nameTop = driver.findElement(By.xpath("//ul[contains(@class,\"user-menu\")]/li[4]/a"));
        nameTop.click();
        String actualName = nameTop.getText();

        WebElement MyConfig = driver.findElement(By.xpath("//li[contains(@class,\"dropdown user-menu-dropdown open\")]/ul/li[2]/a"));
//
        MyConfig.click();
        driver.getTitle();
        String expectedName = driver.getTitle();

        if(expectedName.startsWith(actualName)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expectedName not the same with name on top right"+ actualName);
        }
    }
}
