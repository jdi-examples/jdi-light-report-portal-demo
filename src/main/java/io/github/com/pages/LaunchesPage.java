package io.github.com.pages;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;

public class LaunchesPage extends HomePage {
    @JDropdown(root = "[class*=allLatestDropdown__all-latest-dropdown]",
            value = "[class*=allLatestDropdown__value--]",
            list = "[class*=allLatestDropdown__option-list] div",
            expand = "[class*=allLatestDropdown__icon]")
    public static Dropdown launchesDropdown;
}
