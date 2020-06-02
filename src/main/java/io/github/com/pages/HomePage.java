package io.github.com.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.composites.Header;

public abstract class HomePage extends WebPage {
    @UI("[class*=appHeader__header]")
    public static Header header;

    @UI("[class*=sidebar__top-block]['%s']")
    public static Menu sideBarMenu;
}
