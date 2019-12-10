package com.cybertek.tests.d14_properties_driver_class_test_base_class;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void login(){
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().findElement(By.id("prependedInput")).sendKeys("user1");
        Driver.get().findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
    }
}
