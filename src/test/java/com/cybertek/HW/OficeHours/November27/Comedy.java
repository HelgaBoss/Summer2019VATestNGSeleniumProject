package com.cybertek.HW.OficeHours.November27;

public class Comedy extends Movie {

    @Override
    public double calcLateFees(int days) {
        return days *2.50;
    }
}
