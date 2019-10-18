package com.cybertek.tests;

import com.github.javafaker.Faker;

public class FisrtClass {
    public static void main(String[] args) {
        System.out.println("Adsvfdxbvds");

        Faker faker = new Faker();

        System.out.println(faker.name().fullName());

        System.out.println(faker.chuckNorris().fact());

    }
}
