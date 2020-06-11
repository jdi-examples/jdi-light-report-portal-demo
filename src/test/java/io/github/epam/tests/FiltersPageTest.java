package io.github.epam.tests;

import com.epam.jdi.light.ui.html.elements.common.Button;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static io.github.com.StaticSite.launchesPage;
import static io.github.com.composites.AddFilterView.moreEntitiesSelector;
import static io.github.com.composites.AddFilterView.saveFilterButton;
import static io.github.com.composites.ConditionalEntities.filterInputField;
import static io.github.com.composites.ModalAddDialog.modalAddButton;
import static io.github.com.composites.ModalAddDialog.modalNewName;
import static io.github.com.composites.ModalDeleteDialog.confirmDelete;
import static io.github.com.entities.AddFilterMenu.LAUNCH_NUMBER;
import static io.github.com.entities.SideBarMenu.FILTERS;
import static io.github.com.pages.FiltersPage.addFilterButtons;
import static io.github.com.pages.FiltersPage.deleteFilter;
import static io.github.com.pages.FiltersPage.emptyFiltersBlock;
import static io.github.com.pages.FiltersPage.filterSearchField;
import static io.github.com.pages.HomePage.modalAddDialog;
import static io.github.com.pages.HomePage.modalDeleteDialog;
import static io.github.com.pages.HomePage.sideBarMenu;
import static io.github.com.pages.HomePage.spinnerBlock;
import static io.github.com.pages.LaunchesPage.filters;

public class FiltersPageTest extends TestsBase {
    private List<Button> deletedButtonsList;

    @BeforeMethod(alwaysRun = true)
    public void navigateToFiltersDashboard() {
        sideBarMenu.select(FILTERS.getName());
        deletedButtonsList = deleteFilter;
    }

    @Test
    public void verifyThatUserCannotSearchByFilterNameIfNoFilters() {
        spinnerBlock.waitFor().disappear();
        if (emptyFiltersBlock.isHidden()) {
            filterSearchField.is().enabled();
        } else {
            filterSearchField.is().disabled();
        }
    }

    @Test
    public void verifyThatUserCanProceedToAddNewFilterUsingButton() {
        addFilterButtons.get("Add Filter").click();
        launchesPage.shouldBeOpened();
    }

    @Test
    public void verifyThatUserCanAddNewFilter() {
        String expectedFilterName = new Random().nextInt(1000) + "_test_filter";
        addFilterButtons.get("Add Filter").click();
        filterInputField.get(1).sendKeys("test");
        moreEntitiesSelector.select(LAUNCH_NUMBER.getName());
        moreEntitiesSelector.is().collapsed();
        filterInputField.get(2).sendKeys("1");
        saveFilterButton.click();
        modalNewName.setValue(expectedFilterName);
        modalAddButton.click();
        modalAddDialog.shouldBe().disappear();
        filters.getUIElement(expectedFilterName).isVisible();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        for (Button button : deletedButtonsList) {
            button.click();
            modalDeleteDialog.shouldBe().displayed();
            confirmDelete.click();
        }
    }
}
