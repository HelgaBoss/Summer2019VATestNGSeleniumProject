package com.cybertek.tests.o2_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;


public class AmazonSearchTests {
    public static void main(String[] args) {
        priceDetail();
        bookDetailTest();
        titleTest();

    }
    private static void priceDetail(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("selenium cookbook");
        WebElement searchBtn = driver.findElement(By.className("nav-input"));
        searchBtn.click();

        WebElement book = driver.findElement(By.linkText("Selenium Testing Tools Cookbook - Second Edition"));
        book.click();

        String expectedPaperbackPrice = "$44.99";

        WebElement pPrice = driver.findElement(By.xpath("(//span[@class='a-size-base mediaTab_subtitle'])[2]"));
        String actualPPrice = pPrice.getText();

        if(expectedPaperbackPrice.equals(actualPPrice)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actual price = "+actualPPrice);
            System.out.println("expectedPaperbackPrice = "+expectedPaperbackPrice);
        }
        driver.quit();
    }


    private static void bookDetailTest(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://amazon.com");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("selenium book");
        WebElement searchBtn = driver.findElement(By.className("nav-input"));
        searchBtn.click();

        String expectBook = "Mastering Selenium WebDriver 3.0: Boost the performance and reliability of your automated checks by mastering Selenium WebDriver, 2nd Edition";
        WebElement res1 = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));

        String actualBook = res1.getText();

        if(expectBook.equals(actualBook)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actualBook = " + actualBook);
            System.out.println("expectedBook = " + expectBook);
        }

        String expectedAuthor = "Mark Collin";
        WebElement author1 = driver.findElement(By.xpath("(//a[@class='a-size-base a-link-normal'])[1]"));
        String actualAuthor = author1.getText();

        if(expectedAuthor.equals(actualAuthor)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actualAuthor = " + actualAuthor);
            System.out.println("expectedAuthor = " + expectedAuthor);
        }
        driver.quit();

    }
    private static void titleTest(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("selenium cookbook");
        WebElement searchBtn = driver.findElement(By.className("nav-input"));
        searchBtn.click();
        WebElement booksLink = driver.findElement(By.linkText("Books"));
        booksLink.click();
        String title = driver.getTitle();
        System.out.println(title);
        if (title.endsWith("Books")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println(title + ": did not end with Books");
        }
        WebElement anyDepartmnet = driver.findElement(By.linkText("Any Department"));
        anyDepartmnet.click();

        title = driver.getTitle();
        if(!title.endsWith("Books")){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("ACUAL: "+title);
        }
        driver.quit();
    }

}
