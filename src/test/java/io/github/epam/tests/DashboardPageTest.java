package io.github.epam.tests;

import com.epam.jdi.light.ui.html.elements.common.Icon;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static io.github.com.composites.ItemDashboardView.deleteDashboard;
import static io.github.com.composites.ModalAddDialog.modalAddButton;
import static io.github.com.composites.ModalAddDialog.modalAddTitle;
import static io.github.com.composites.ModalAddDialog.modalCancelButton;
import static io.github.com.composites.ModalAddDialog.modalDescription;
import static io.github.com.composites.ModalAddDialog.modalNewName;
import static io.github.com.composites.ModalDeleteDialog.confirmDelete;
import static io.github.com.entities.SideBarMenu.DASHBOARD;
import static io.github.com.pages.DashboardPage.addNewDashboardButton;
import static io.github.com.pages.DashboardPage.dashboardSearchField;
import static io.github.com.pages.DashboardPage.dashboardTitle;
import static io.github.com.pages.DashboardPage.deleteDashboardIcon;
import static io.github.com.pages.DashboardPage.noDashboardBlock;
import static io.github.com.pages.HomePage.modalAddDialog;
import static io.github.com.pages.HomePage.modalDeleteDialog;
import static io.github.com.pages.HomePage.sideBarMenu;

public class DashboardPageTest extends TestsBase {
    private List<Icon> deleteButtonsList;

    @BeforeMethod(alwaysRun = true)
    public void navigateToLaunchesDashboard() {
        sideBarMenu.select(DASHBOARD.getName());
        deleteButtonsList = deleteDashboardIcon;
    }

    @Test
    public void verifyThatUserCannotSearchByFilterNameIfNoFilters() {
        if (noDashboardBlock.isHidden()) {
            dashboardSearchField.is().enabled();
        } else {
            dashboardSearchField.is().disabled();
        }
    }

    @Test
    public void verifyThatUserCanOpenAndCancelNewDashboardDialog() {
        String expectedModalDialogTitle = "Add New Dashboard";
        addNewDashboardButton.click();
        modalAddTitle.assertThat().text(expectedModalDialogTitle.toUpperCase());
        modalCancelButton.click();
        modalAddDialog.isNotVisible();
    }

    @Test
    public void verifyThatUserAddNewDashboard() {
        String expectedDashboardName = new Random().nextInt(1000) + "_test_dashboard";
        String expectedDashboardDescription = expectedDashboardName + "_description";
        addNewDashboardButton.click();
        modalNewName.setValue(expectedDashboardName);
        modalDescription.setValue(expectedDashboardDescription);
        modalAddButton.click();
        dashboardTitle.assertThat().text(expectedDashboardName.toUpperCase());
        deleteDashboard.click();
        modalDeleteDialog.shouldBe().displayed();
        confirmDelete.click();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        for (Icon button : deleteButtonsList) {
            button.click();
            modalDeleteDialog.shouldBe().displayed();
            confirmDelete.click();
        }
    }
}
