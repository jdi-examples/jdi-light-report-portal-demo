package io.github.com.composites;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class Header extends Section {
    @UI("[class*=userBlock__username]")
    public static Text userName;

    @UI("[class*=userBlock__menu-icon]")
    public static Icon menuIcon;

    @JDropdown(root = "[class*=project-selector]",
            value = "[class*=current-project-name]",
            list = "[class*=scrolling-content] a",
            expand = "[class*=show-list-icon]")
    public static Dropdown projectSelector;
}
