package io.github.epam.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static io.github.com.composites.AddFilterDialog.addFilter;
import static io.github.com.composites.AddFilterDialog.addFilterTitle;
import static io.github.com.composites.AddFilterDialog.cancelAddFilter;
import static io.github.com.composites.AddFilterDialog.newFilterName;
import static io.github.com.composites.AddFilterView.moreDropdown;
import static io.github.com.composites.AddFilterView.saveFilterButton;
import static io.github.com.composites.ConditionalEntities.filterInputField;
import static io.github.com.composites.DeleteFilterDialog.confirmDelete;
import static io.github.com.entities.AddFilterMenu.LAUNCH_NUMBER;
import static io.github.com.entities.LaunchesFilter.ALL_LAUNCHES;
import static io.github.com.entities.LaunchesFilter.LATEST_LAUNCHES;
import static io.github.com.entities.SideBarMenu.FILTERS;
import static io.github.com.entities.SideBarMenu.LAUNCHES;
import static io.github.com.pages.DashboardPage.addFilterDialog;
import static io.github.com.pages.FiltersPage.deleteFilter;
import static io.github.com.pages.FiltersPage.filterTitle;
import static io.github.com.pages.HomePage.sideBarMenu;
import static io.github.com.pages.LaunchesPage.addFilterButton;
import static io.github.com.pages.LaunchesPage.launchesDropdown;

public class LaunchesPageTest extends TestsBase {
    @BeforeMethod
    public void navigateToLaunchesDashboard() {
        sideBarMenu.select(LAUNCHES.getName());
    }

    @Test
    public void verifyThatUserCanChooseLatestLaunches() {
        String expectedLaunchesType = ALL_LAUNCHES.getName();
        launchesDropdown.select(expectedLaunchesType);
        launchesDropdown.is().selected(expectedLaunchesType.toUpperCase());
    }

    @Test
    public void verifyThatUserCanChooseAllLaunches() {
        String expectedLaunchesType = LATEST_LAUNCHES.getName();
        launchesDropdown.select(expectedLaunchesType);
        launchesDropdown.is().selected(expectedLaunchesType.toUpperCase());
    }

    @Test
    public void verifyThatUserCanOpenAndCancelNewFilterDialog() {
        String expectedModalDialogTitle = "Add Filter";
        addFilterButton.click();
        filterInputField.get(1).sendKeys("test");
        saveFilterButton.click();
        addFilterTitle.assertThat().text(expectedModalDialogTitle.toUpperCase());
        cancelAddFilter.click();
        addFilterDialog.isNotVisible();
    }
    @Test
    public void verifyThatUserCanAddNewFilter() {
        String expectedFilterName = new Random().nextInt(1000) + "_test_filter";
        addFilterButton.click();
        filterInputField.get(1).sendKeys("test");
        moreDropdown.select(LAUNCH_NUMBER.getName());
        filterInputField.get(2).sendKeys("1");
        saveFilterButton.click();
        newFilterName.setValue(expectedFilterName);
        addFilter.click();
        sideBarMenu.select(FILTERS.getName());
        filterTitle.getUIElement(expectedFilterName).assertThat().text(expectedFilterName);
        deleteFilter.get(1).click();
        confirmDelete.click();
    }
}
