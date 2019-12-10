package com.cybertek.HW.Test_Cases2;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class testCase7  extends TestBase {
    @Test
    public void test() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        // 2 click on file upload
        driver.findElement(By.xpath("//a[@href='/upload']")).click();
        //3. Upload any file with .txt extension from your computer.
        driver.findElement(By.id("file-upload")).sendKeys("/Users/user/Desktop/file.txt");
        // 4.
        driver.findElement(By.id("file-submit")).click();
        // 5.
        driver.findElement(By.xpath("//div/h3[text()='File Uploaded!']"));
        // 6.
       String file = driver.findElement(By.id("uploaded-files")).getText();

        System.out.println(file);

    }
}
