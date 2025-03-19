package org.example.pageobjects;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

/**
 * This is the PageObject class for HomePage.
 * All Elements and Functions on the Page are defined in this class.
 *
 * @author nuwan.o (01-Jan-2025)
 * @version 0.1
 * @since 01-Jan-2025
 */

public class HomePage extends BasePage {

    /* Constructor */
    public HomePage(Page page) {
        super(page);
    }

    /* Public Functions */

    /**
     * This method will be exposed in test case to check the logged in status.
     * @return isVisible output
     */
    public boolean isUserLoggedIn() {
        Locator welcomeText = page.getByText("Welcome to the PlayWright");
        assertThat(welcomeText).isVisible();
        return welcomeText.isVisible();
    }
}
