package com.cybertek.tests.o3_pom;

import com.cybertek.pages.ContactInformationPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInformationTests extends TestBase {

    /*
        Go to https://qa3.vytrack.com/user/login
        Go to customers —> contacts
        Click on email mbrackstone9@example.com
        Verify that full name is Ms Mariam Brackstone
        Verify that email is 18982323434
        Verify that phone number is   mbrackstone9@example.com

     */
    @Test
    public void contactDetailsTest() {
        // add this test to the extent report    ---> we take from NegativeLoginTestWithReports
        extentLogger = report.createTest("Contact details test");


        // And Login
        extentLogger.info("Login");
        LoginPage loginPage = new LoginPage();
        String userName = ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");
        extentLogger.info("username:" + userName);
        extentLogger.info("password:" + password);
        loginPage.login(userName,password);

        //         Go to customers —> contacts
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.navigateToModule("Customers","Contacts");

        //Click on email mbrackstone9@example.com
        extentLogger.info("Click on email mbrackstone9@example.com");

        // wait before click on email
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        // Verify that full name is Ms Mariam Brackstone
        ContactInformationPage contactInformationPage = new ContactInformationPage();
        extentLogger.info("Verify that full name is Ms Mariam Brackstone");
        String actualName = contactInformationPage.contactFullName.getText();
        Assert.assertEquals("Ms Mariam Brackstone", actualName);


        extentLogger.info("Verify that email is 18982323434");
        String actualPhone = contactInformationPage.phone.getText();
        Assert.assertEquals(actualPhone,"18982323434");

        extentLogger.info("Verify that phone number is   mbrackstone9@example.com");
        String actualEmail = contactInformationPage.email.getText();
        Assert.assertEquals(actualEmail,"mbrackstone9@example.com");


    }
}
