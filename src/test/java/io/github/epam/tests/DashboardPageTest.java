package io.github.epam.tests;

import io.github.com.composites.AddDashboardDialog;
import io.github.com.entities.SideBarMenu;
import org.testng.annotations.Test;

import java.util.Random;

import static io.github.com.composites.AddDashboardDialog.addDashboard;
import static io.github.com.composites.AddDashboardDialog.addDashboardTitle;
import static io.github.com.composites.AddDashboardDialog.cancelAdd;
import static io.github.com.composites.AddDashboardDialog.description;
import static io.github.com.composites.DeleteDashboardDialog.confirmDelete;
import static io.github.com.composites.ItemDashboardView.deleteDashboard;
import static io.github.com.pages.DashboardPage.addDashboardDialog;
import static io.github.com.pages.DashboardPage.addNewDashboardButton;
import static io.github.com.pages.DashboardPage.dashboardTitle;
import static io.github.com.pages.HomePage.sideBarMenu;

public class DashboardPageTest extends TestsBase {
    @Test
    public void verifyThatUserCanOpenAndCancelNewDashboardDialog() {
        String expectedModalDialogTitle = "Add New Dashboard";
        sideBarMenu.select(SideBarMenu.DASHBOARD.getName());
        addNewDashboardButton.click();
        addDashboardTitle.assertThat().text(expectedModalDialogTitle.toUpperCase());
        cancelAdd.click();
        addDashboardDialog.isNotVisible();
    }

    @Test
    public void verifyThatUserAddNewDashboard() {
        String newDashboardName = new Random().nextInt(1000) + "_test_dashboard";
        String newDashboardDescription = newDashboardName + "_description";
        sideBarMenu.select(SideBarMenu.DASHBOARD.getName());
        addNewDashboardButton.click();
        AddDashboardDialog.newDashboardName.setValue(newDashboardName);
        description.setValue(newDashboardDescription);
        addDashboard.click();
        dashboardTitle.assertThat().text(newDashboardName.toUpperCase());
        deleteDashboard.click();
        confirmDelete.click();
    }
}
