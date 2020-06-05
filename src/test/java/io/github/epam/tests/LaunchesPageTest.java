package io.github.epam.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.composites.AddFilterView.saveFilterButton;
import static io.github.com.composites.ConditionalEntities.filterInputField;
import static io.github.com.composites.ModalAddDialog.modalAddTitle;
import static io.github.com.composites.ModalAddDialog.modalCancelButton;
import static io.github.com.entities.LaunchesFilter.ALL_LAUNCHES;
import static io.github.com.entities.LaunchesFilter.LATEST_LAUNCHES;
import static io.github.com.entities.SideBarMenu.LAUNCHES;
import static io.github.com.pages.HomePage.modalAddDialog;
import static io.github.com.pages.HomePage.sideBarMenu;
import static io.github.com.pages.LaunchesPage.addFilterButton;
import static io.github.com.pages.LaunchesPage.launchesDropdown;

public class LaunchesPageTest extends TestsBase {
    @BeforeMethod(alwaysRun = true)
    public void navigateToLaunchesDashboard() {
        sideBarMenu.select(LAUNCHES.getName());
    }

    @Test
    public void verifyThatUserCanChooseLaunchesType() {
        String expectedLatestType = LATEST_LAUNCHES.getName();
        launchesDropdown.select(expectedLatestType);
        launchesDropdown.is().selected(expectedLatestType.toUpperCase());
        String expectedAllType = ALL_LAUNCHES.getName();
        launchesDropdown.select(expectedAllType);
        launchesDropdown.is().selected(expectedAllType.toUpperCase());
    }

    @Test
    public void verifyThatUserCanOpenAndCancelNewFilterDialog() {
        String expectedModalDialogTitle = "Add Filter";
        addFilterButton.click();
        filterInputField.get(1).sendKeys("test");
        saveFilterButton.click();
        modalAddTitle.assertThat().text(expectedModalDialogTitle.toUpperCase());
        modalCancelButton.click();
        modalAddDialog.isNotVisible();
    }
}
