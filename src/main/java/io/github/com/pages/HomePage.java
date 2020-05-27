package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class HomePage extends WebPage {

    @UI("//div[contains(@class, 'username')]")
    public static Text userName;

    @UI("//div[contains(@class, 'layout__corner')]")
    public static Button logoButton;
}
