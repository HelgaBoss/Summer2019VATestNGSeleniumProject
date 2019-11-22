package com.cybertek.HW.locator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WoodenSpoon {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://ebay.com");

        WebElement search = driver.findElement(By.id("gh-ac"));

        String str = "wooden spoon";
        search.sendKeys(str);
        search.submit();

        WebElement result = driver.findElement(By.xpath("//h1/span[@class='BOLD']"));
        String results = result.getText();
        results = results.replace(",", "");
        int num = Integer.parseInt(results);
        Thread.sleep(3000);
        WebElement link = driver.findElement(By.xpath("//div[@id='x-refine__group__0']/ul/li/a"));
        link.click();
        WebElement Result= driver.findElement(By.xpath("//h1/span[@class='BOLD']"));
        String actualResult = Result.getText();
        actualResult=actualResult.replace(",", "");
        int num1 = Integer.parseInt(actualResult);
        if(num1 > num) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIl");
            System.out.println("actualResult: "+num1+"not bigger than"+ num);
            System.out.println("expectedResult: "+num+"not smaller than"+num1);
        }
        driver.navigate().back();
    }


}
