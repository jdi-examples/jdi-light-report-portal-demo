package io.github.epam.tests;

import com.epam.jdi.light.ui.html.elements.common.Button;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static io.github.com.composites.AddFilterView.moreEntitiesSelector;
import static io.github.com.composites.AddFilterView.saveFilterButton;
import static io.github.com.composites.ConditionalEntities.filterInputField;
import static io.github.com.composites.ModalAddDialog.modalAddButton;
import static io.github.com.composites.ModalAddDialog.modalAddTitle;
import static io.github.com.composites.ModalAddDialog.modalCancelButton;
import static io.github.com.composites.ModalAddDialog.modalNewName;
import static io.github.com.composites.ModalDeleteDialog.confirmDelete;
import static io.github.com.entities.AddFilterMenu.LAUNCH_NUMBER;
import static io.github.com.entities.LaunchesFilter.ALL_LAUNCHES;
import static io.github.com.entities.LaunchesFilter.LATEST_LAUNCHES;
import static io.github.com.entities.SideBarMenu.FILTERS;
import static io.github.com.entities.SideBarMenu.LAUNCHES;
import static io.github.com.pages.FiltersPage.deleteFilter;
import static io.github.com.pages.FiltersPage.filterTitle;
import static io.github.com.pages.HomePage.modalAddDialog;
import static io.github.com.pages.HomePage.modalDeleteDialog;
import static io.github.com.pages.HomePage.sideBarMenu;
import static io.github.com.pages.LaunchesPage.addFilterButton;
import static io.github.com.pages.LaunchesPage.launchesDropdown;

public class LaunchesPageTest extends TestsBase {
    private List<Button> deletedButtonsList;

    @BeforeMethod(alwaysRun = true)
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
        modalAddTitle.assertThat().text(expectedModalDialogTitle.toUpperCase());
        modalCancelButton.click();
        modalAddDialog.isNotVisible();
    }

    @Test
    public void verifyThatUserCanAddNewFilter() {
        String expectedFilterName = new Random().nextInt(1000) + "_test_filter";
        addFilterButton.click();
        filterInputField.get(1).sendKeys("test");
        moreEntitiesSelector.select(LAUNCH_NUMBER.getName());
        filterInputField.get(2).sendKeys("1");
        saveFilterButton.click();
        modalNewName.setValue(expectedFilterName);
        modalAddButton.click();
        sideBarMenu.select(FILTERS.getName());
        deletedButtonsList = deleteFilter;
        filterTitle.getUIElement(expectedFilterName).assertThat().text(expectedFilterName);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        if (deletedButtonsList != null) {
            for (Button button : deletedButtonsList) {
                button.click();
                modalDeleteDialog.shouldBe().displayed();
                confirmDelete.click();
            }
        }
    }
}
