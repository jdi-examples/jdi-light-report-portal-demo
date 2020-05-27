package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class LoginPage extends WebPage {

    @UI("//div[contains(@class, 'username')]")
    public Text userName;
}
