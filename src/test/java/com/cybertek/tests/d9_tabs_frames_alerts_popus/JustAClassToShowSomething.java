package com.cybertek.tests.d9_tabs_frames_alerts_popus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JustAClassToShowSomething {
    // this is different
    String string;

    @BeforeMethod
    public void setup(){
        string = "ok";
    }


    @Test
    public void test(){
        System.out.println(string.equals("ok"));
    }
}
