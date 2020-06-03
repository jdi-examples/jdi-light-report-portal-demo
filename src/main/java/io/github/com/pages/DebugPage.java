package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class DebugPage extends HomePage {
    @UI("[class*=ghostButton__color-topaz] ['Refresh']")
    public static Button refreshButton;
}
