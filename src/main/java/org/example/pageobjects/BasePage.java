package org.example.pageobjects;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

/**
 * This is the Base Page class for PlayWright.
 * All Common features related to PageObjects are defined in this class.
 *
 * @author nuwan.o (01-Jan-2025)
 * @version 0.1
 * @since 01-Jan-2025
 */

public class BasePage {

    /* Variables */
    protected Page page;

    /* Constructor */
    public BasePage(Page page) {
        this.page = page;
    }

    /**
     *  This method will locate elements on page object
     * @param elementName input page element name
     * @param elementType input page element type
     * @return Locater output
     */
    protected Locator locateElement(String elementName, AriaRole elementType){
        return page.getByRole(elementType, new Page.GetByRoleOptions().setName(elementName));
    }

}
