package com.cybertek.tests.d9_tabs_frames_alerts_popus;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class Multiplemethods {

    WebDriver driver;
    @BeforeMethod
    public void setupmethod() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void switchWindowsTest() {
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("Before the new window open: "+driver.getTitle());

        //open the new window
        driver.findElement(By.linkText("Click Here")).click();
        //still shows the title of the old window because we did not switch to the window
        System.out.println("After new window is opened: "+driver.getTitle());

        //window() ---> changes between tabs, windows
//        driver.switchTo().window("New Window");

        String currentWindiwHandle = driver.getWindowHandle();
        System.out.println("currentwindowHandle ="+ currentWindiwHandle);
        //Set is just like arraylist,but without the duplicate values
        //getWindowhandles--> return a set

        Set<String> windowHandles = driver.getWindowHandles();

        for(String windowHandle : windowHandles) {
            System.out.println(windowHandle);
            // itirate the set of handles and compare to the current handle
            // if the handle is not equal to the current than its the handle of the new window
            if(!currentWindiwHandle.equals(windowHandle)) {
                // switch to nw window by passing its handle
                driver.switchTo().window(windowHandle);
            }
        }
        System.out.println("After switching "+driver.getTitle());
    }

    @Test
    public void changeByTitle() {
        driver.get("http://practice.cybertekschool.com/windows");
        String targetTitle = "New Window";
        driver.findElement(By.linkText("Click Here")).click();
        // how many windows sre open right now
        System.out.println(driver.getWindowHandles().size());

        //itirate though all window
        for(String handle: driver.getWindowHandles()) {
            //switch to them one by one
            driver.switchTo().window(handle);
            // get the title and compare target title
            if(driver.getTitle().equals(targetTitle)) {
                //stop looping
                break;
            }
        }
        System.out.println(driver.getTitle());

    }





}
