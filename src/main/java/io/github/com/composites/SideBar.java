package io.github.com.composites;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class SideBar extends Section {
    @UI("['Dashboard']")
    public static Button dashboardButton;

    @UI("['Launches']")
    public static Button launchesButton;

    @UI("['Filters']")
    public static Button filtersButton;

    @UI("['Debug']")
    public static Button debugButton;
}
