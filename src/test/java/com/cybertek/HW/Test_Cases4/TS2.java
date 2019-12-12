package com.cybertek.HW.Test_Cases4;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TS2 extends TestBase {

    WebDriverWait wait;
    WebDriver driver;
    Actions actions;

//    driver.get(ConfigurationReader.get("url"));
//    driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get("user_name"));
//        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.get("password"));
//        driver.findElement(By.id("_submit")).click();
//    WebDriverWait wait = new WebDriverWait(driver, 15);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='title title-level-1'])[5]")));
//        action.moveToElement(driver.findElement(By.xpath("(//span[@class='title title-level-1'])[5]"))).perform();
//        driver.findElement(By.xpath("//span[.='Calendar Events']")).click();
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        WebElement element = driver.findElement(By.xpath("//i[@class='fa-cog hide-text']"));
////        js.executeScript("arguments[0].click()",element);
//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa-cog hide-text']")));
//        driver.findElement(By.xpath("//i[@class='fa-cog hide-text']")).click();
//
//    List<WebElement> titles = driver.findElements(By.xpath("//tbody[@class='ui-sortable']/tr/td[@class='title-cell']"));
//    List<WebElement> boxes = driver.findElements(By.xpath("//tbody[@class='ui-sortable']/tr/td[@class='visibility-cell']"));
//        for (int i = 0; i < titles.size(); i++) {
//        if(!titles.get(i).getText().equals("Title")){
//            boxes.get(i).click();
//        }
//        else{
//            WebElement titlebox = driver.findElement(By.xpath("(//input[contains(@id,'column')])[1]"));
//            Assert.assertTrue(titlebox.isSelected());
//        }
//    }
//    WebElement titlebox = driver.findElement(By.xpath("(//input[contains(@id,'column')])[1]"));
//        Assert.assertTrue(titlebox.isSelected());
}
