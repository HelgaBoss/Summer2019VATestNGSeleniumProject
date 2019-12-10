package com.cybertek.HW.OficeHours.November27;

public class Action extends Movie {

    @Override
    public double calcLateFees(int days) {
        return days *3;

    }
    @Override
    public String toString() {
        return "Action{" +
                "rating='" + getRaiting() + '\'' +
                ", IdNumber=" + getIdNumber() +
                ", title='" + getTitle() + '\'' +
                '}';
    }
}
