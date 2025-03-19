package org.example.tests;

import org.example.pageobjects.HomePage;
import org.example.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * This is the Test class for Login Page.
 * All Test Scenarios for the Page are defined in this class.
 *
 * @author nuwan.o (01-Jan-2025)
 * @version 0.1
 * @since 01-Jan-2025
 */

public class LoginTest extends BaseTest {

    /**
     * Test case: Verify system login with valid credentials
     * 1) Enter username
     * 2) Enter password
     * 3) click login button
     * 4) validate homepage text
     */

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.enterUsername("username");
        loginPage.enterPassword("password");
        HomePage homePage = loginPage.clickLogin();
        Assert.assertTrue(homePage.isUserLoggedIn(), "User should be logged in");
    }



}