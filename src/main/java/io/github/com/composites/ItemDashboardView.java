package io.github.com.composites;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class ItemDashboardView extends Section {
    @UI("['Delete']")
    public static Button deleteDashboard;
}
