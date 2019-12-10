package com.cybertek.HW.Test_Cases2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testCase6 {


    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void t () throws InterruptedException {
        Thread.sleep(3000);
    }


    @Test
    public void test6() {
        //  go to website
        driver.get("https://www.tempmailaddress.com");
        //2. Copy and save email as a string.
       String email =  driver.findElement(By.id("email")).getText();
//        System.out.println(email);
        //3. Then go to ...
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //4. And click on “Sign Up For Mailing List"
        driver.findElement(By.xpath("//a[contains(text(),'Up For Mailing')]")).click();
        //5. Enter any valid name.
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("HelgaBSS");
        //6. Enter email from the Step 2
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        // 7. Click Sign Up
        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();
        //  8. Verify that following message is displayed:

        WebElement mssge = driver.findElement(By.xpath("//h3[@name='signup_message']"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(mssge));
        Assert.assertTrue(mssge.isDisplayed());


        //  Navigate back to the “https:// www.tempmailaddress.com/”
        driver.navigate().to("https://www.tempmailaddress.com");
        driver.navigate().refresh();

        //10. Verify that you’ve received an email from
        //“do-not-reply@practice.cybertekschool.com”
        WebElement verify = driver.findElement(By.xpath("//tbody/tr/td[@class= 'from']"));
        String actualemail = verify.getText();
        System.out.println(actualemail);
        actualemail = actualemail.trim();

        //12. Verify that email is from: “do-not- reply@practice.cybertekschool.com”
        String expectedEmail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualemail,expectedEmail);
        verify.click();

        //13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
        WebElement subject = driver.findElement(By.xpath("//*[.='do-not-reply@practice.cybertekschool.com']"));
        String actualSubject = subject.getText();
        actualSubject = actualSubject.trim();
        String expectedSubject = "do-not-reply@practice.cybertekschool.com";
//        System.out.println(actualSubject);
        Assert.assertEquals(actualSubject,expectedSubject);

        // 13.
        WebElement verify3 = driver.findElement(By.id("predmet"));
        String actualVerify3 = verify3.getText();
        System.out.println(actualVerify3);
        String expectedVerify3 = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualVerify3,expectedVerify3);



    }
}
