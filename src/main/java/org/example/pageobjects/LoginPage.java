package org.example.pageobjects;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

/**
 * This is the PageObject class for LoginPage.
 * All Elements and Functions on the Page are defined in this class.
 *
 * @author nuwan.o (01-Jan-2025)
 * @version 0.1
 * @since 01-Jan-2025
 */

public class LoginPage extends BasePage {

    /* UI Elements */
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    /* Constructor */
    public LoginPage(Page page) {
        super(page);
        this.usernameInput = locateElement("Username", AriaRole.TEXTBOX);
        this.passwordInput = locateElement("Password", AriaRole.TEXTBOX);
        this.loginButton = locateElement("Login", AriaRole.BUTTON);
    }

    /* Public Functions */

    /**
     * This method will be exposed in test case to enter username in textbox
     * @param username input username
     */
    public void enterUsername(String username) {
        usernameInput.fill(username);
    }

    /**
     * This method will be exposed in test case to enter password in textbox
     * @param password input username
     */
    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    /**
     * This method will be exposed in test case to click login button
     */
    public HomePage clickLogin() {
        loginButton.click();
        return new HomePage(page);
    }
}
