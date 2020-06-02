package io.github.epam.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static io.github.com.composites.AddDashboardDialog.addDashboard;
import static io.github.com.composites.AddDashboardDialog.addDashboardTitle;
import static io.github.com.composites.AddDashboardDialog.cancelAddDashboard;
import static io.github.com.composites.AddDashboardDialog.dashboardDescription;
import static io.github.com.composites.AddDashboardDialog.newDashboardName;
import static io.github.com.composites.DeleteDashboardDialog.confirmDelete;
import static io.github.com.composites.ItemDashboardView.deleteDashboard;
import static io.github.com.entities.SideBarMenu.DASHBOARD;
import static io.github.com.pages.DashboardPage.addDashboardDialog;
import static io.github.com.pages.DashboardPage.addNewDashboardButton;
import static io.github.com.pages.DashboardPage.dashboardSearchField;
import static io.github.com.pages.DashboardPage.dashboardTitle;
import static io.github.com.pages.DashboardPage.noDashboardBlock;
import static io.github.com.pages.HomePage.sideBarMenu;

public class DashboardPageTest extends TestsBase {
    @BeforeMethod
    public void navigateToLaunchesDashboard() {
        sideBarMenu.select(DASHBOARD.getName());
    }

    @Test
    public void verifyThatUserCannotSearchByDashboardNameIfNoDashboards() {
        if (noDashboardBlock.isHidden()) {
            dashboardSearchField.is().disabled();
        } else {
            dashboardSearchField.is().enabled();
        }
    }

    @Test
    public void verifyThatUserCanOpenAndCancelNewDashboardDialog() {
        String expectedModalDialogTitle = "Add New Dashboard";
        addNewDashboardButton.click();
        addDashboardTitle.assertThat().text(expectedModalDialogTitle.toUpperCase());
        cancelAddDashboard.click();
        addDashboardDialog.isNotVisible();
    }

    @Test
    public void verifyThatUserAddNewDashboard() {
        String expectedDashboardName = new Random().nextInt(1000) + "_test_dashboard";
        String expectedDashboardDescription = expectedDashboardName + "_description";
        addNewDashboardButton.click();
        newDashboardName.setValue(expectedDashboardName);
        dashboardDescription.setValue(expectedDashboardDescription);
        addDashboard.click();
        dashboardTitle.assertThat().text(expectedDashboardName.toUpperCase());
        deleteDashboard.click();
        confirmDelete.click();
    }
}
