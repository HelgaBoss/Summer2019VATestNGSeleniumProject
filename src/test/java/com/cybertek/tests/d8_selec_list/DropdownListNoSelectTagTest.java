package com.cybertek.tests.d8_selec_list;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownListNoSelectTagTest {

    @Test
    public void test() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        Select list = new Select(driver.findElement(By.id("dropdownMenuLink")));
    }
}
