package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.composites.ItemDashboardView;

import java.util.List;

public class DashboardPage extends HomePage {
    @UI("[class*=pageBreadcrumbs] [title]")
    public static Text dashboardTitle;

    @UI("input[type='text']")
    public static TextField dashboardSearchField;

    @UI("[class*=addDashboardButton] button")
    public static Button addNewDashboardButton;

    @UI("[class*=dashboard-item]")
    public static ItemDashboardView itemDashboardView;

    @UI("[class*=emptyDashboards]")
    public static Section noDashboardBlock;

    @UI("[class*=icon-delete]")
    public static List<Icon> deleteDashboardIcon;
}
