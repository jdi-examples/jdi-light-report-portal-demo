package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.composites.AddDashboardDialog;
import io.github.com.composites.AddFilterDialog;
import io.github.com.composites.AddFilterView;
import io.github.com.composites.DeleteDashboardDialog;
import io.github.com.composites.DeleteFilterDialog;
import io.github.com.composites.ItemDashboardView;

public class DashboardPage extends HomePage {
    @UI("[class*=pageBreadcrumbs] [title]")
    public static Text dashboardTitle;

    @UI("input[type='text']")
    public static TextField dashboardSearchField;

    @UI("[class*=addDashboardButton] button")
    public static Button addNewDashboardButton;

    @UI("[class*=modal-window]")
    public static AddDashboardDialog addDashboardDialog;

    @UI("[class*=modal-window]")
    public static DeleteDashboardDialog deleteDashboardDialog;

    @UI("[class*=dashboard-item]")
    public static ItemDashboardView itemDashboardView;

    @UI("[class*=filter-controls-container]")
    public static AddFilterView addFilterView;

    @UI("[class*=modal-window]")
    public static AddFilterDialog addFilterDialog;

    @UI("[class*=modal-window]")
    public static DeleteFilterDialog deleteFilterDialog;

    @UI("[class*=emptyDashboards]")
    public static Section noDashboardBlock;
}
