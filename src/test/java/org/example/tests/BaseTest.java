package org.example.tests;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

/**
 * This is the Base Test class for PlayWright.
 * All Common features related to Tests are defined in this class.
 *
 * @author nuwan.o (01-Jan-2025)
 * @version 0.1
 * @since 01-Jan-2025
 */

public class BaseTest {

    /* Variables */
    protected static Playwright playwright;
    protected static Browser browser;
    protected Page page;
    protected BrowserContext context;

    /* Constructor */
    public BaseTest() {
        playwright = Playwright.create();
    }

    /**
     *  This method will execute BeforeSuite
     *  Web browser initialization will be done here
     */
    @BeforeSuite
    public static void setUp() {
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    /**
     *  This method will execute BeforeTest in each test class
     *  Browser context setup and initial page navigation will be done here
     */
    @BeforeTest
    public void createContext() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("http://www.example.com:8080/login/");
    }

    /**
     *  This method will execute AfterTest in each test class
     *  Browser context closing will be done here
     */
    @AfterTest
    public void closeContext() {
        context.close();
    }

    /**
     *  This method will execute TestSuite
     *  Browser closing will be done here
     */
    @AfterSuite
    public void tearDown() {
        browser.close();
        playwright.close();
    }

}
