package io.github.com.composites;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class AddFilterView extends Section {
    @JDropdown(root = "[class*=entities-selector]",
            value = "[class*=entitiesSelector__toggler]",
            list = "[class*=entitiesSelector__entities-list] span",
            expand = "[class*=entitiesSelector__toggler]")
    public static Dropdown moreEntitiesSelector;

    @UI("[class*=entities-group]")
    public static ConditionalEntities addFilterSection;

    @UI("button[title='Save']")
    public static Button saveFilterButton;
}
