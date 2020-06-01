package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.composites.AddDashboardDialog;
import io.github.com.composites.DeleteDashboardDialog;
import io.github.com.composites.ItemDashboardView;

public class DashboardPage extends HomePage {
    @UI("[class*=pageBreadcrumbs] [title]")
    public static Text dashboardTitle;

    @UI("[class*=addDashboardButton] button")
    public static Button addNewDashboardButton;

    @UI("[class*=modal-window]")
    public static AddDashboardDialog addDashboardDialog;

    @UI("[class*=modal-window]")
    public static DeleteDashboardDialog deleteDashboardDialog;

    @UI("[class*=dashboard-item]")
    public static ItemDashboardView itemDashboardView;
}
