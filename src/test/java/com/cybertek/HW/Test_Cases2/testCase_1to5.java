package com.cybertek.HW.Test_Cases2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testCase_1to5 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void test1() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Click on “Registration Form”
        driver.findElement(By.xpath("//a[text()= 'Registration Form']")).click();
        //into date of birth input box.
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("11.21.24");
        String message =  driver.findElement(By.xpath("//small[@data-bv-validator='date']")).getText();
        //Verify that warning message is displayed:
        Assert.assertTrue(message.equals("The date of birth is not valid"));
        System.out.println(message);
    }

    @Test
    public void test2 () {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Click on “Registration Form”
        driver.findElement(By.xpath("//a[text()= 'Registration Form']")).click();
        // Verify C++
        WebElement cPlus =  driver.findElement(By.xpath("//label[@for='inlineCheckbox1']"));
        //Verify java
        WebElement java = driver.findElement(By.xpath("//label[@for='inlineCheckbox2']"));
        //verify JavaScript
        WebElement JavaScript = driver.findElement(By.xpath("//label[@for='inlineCheckbox3']"));


        Assert.assertTrue(cPlus.isDisplayed());
        Assert.assertTrue(java.isDisplayed());
        Assert.assertTrue(JavaScript.isDisplayed());

    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()= 'Registration Form']")).click();
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("a");
        Thread.sleep(3000);
        WebElement input = driver.findElement(By.xpath("//small[@data-bv-validator='stringLength'][@data-bv-for='lastname']"));
        Assert.assertTrue(input.isDisplayed());

    }
    @Test
    public void test5() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Click on “Registration Form”
        driver.findElement(By.xpath("//a[text()= 'Registration Form']")).click();
        //Enter any valid first name
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Alexa");
        //last name
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Petrova");
        //user name
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("petrFisrt");
        // email
        driver.findElement(By.xpath("//input[@name ='email']")).sendKeys("solton123@gmail.com");
        //password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qewewwqe2132312");
        //phoneNumber
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("122-343-2323");
        //gender
        driver.findElement(By.xpath("//input[@value='female']")).click();
        //DOB
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("04/23/1999");
        // 10. Select your department
        Select selectDepartment = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        String actualSelection =  selectDepartment.getFirstSelectedOption().getText();
        System.out.println("actualSelection = " +actualSelection);

        selectDepartment.selectByVisibleText("MCR");

        //11. Enter any job title.
        Select selectJobTitle = new Select(driver.findElement(By.xpath("//select[@name ='job_title']")));
        selectJobTitle.selectByVisibleText("QA");

        //12. Select java as a programming language.
        driver.findElement(By.xpath("//label[@for='inlineCheckbox2']")).click();

        //13. Click Sign up.
        driver.findElement(By.id("wooden_spoon")).click();
        //14 Verify
        WebElement message = driver.findElement(By.xpath("//div/p"));
        Assert.assertTrue(message.isDisplayed());

    }
}
