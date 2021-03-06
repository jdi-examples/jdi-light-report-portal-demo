package io.github.com.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.com.composites.AddFilterView;

public class LaunchesPage extends HomePage {
    @JDropdown(root = "[class*=allLatestDropdown__all-latest-dropdown]",
            value = "[class*=allLatestDropdown__value--]",
            list = "[class*=allLatestDropdown__option-list] div",
            expand = "[class*=allLatestDropdown__icon]")
    public static Dropdown launchesDropdown;

    @UI("[class*=ghostButton__color-topaz] ['Add filter']")
    public static Button addFilterButton;

    @UI("[class*=filter-controls-container]")
    public static AddFilterView addFilterView;

    @UI("[class*=filterItem__name]")
    public static WebList filters;
}
