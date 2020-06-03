package io.github.epam.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.launchesPage;
import static io.github.com.entities.SideBarMenu.FILTERS;
import static io.github.com.pages.FiltersPage.addFilterButtons;
import static io.github.com.pages.FiltersPage.filterSearchField;
import static io.github.com.pages.FiltersPage.noFiltersBlock;
import static io.github.com.pages.HomePage.sideBarMenu;

public class FiltersPageTest extends TestsBase {
    @BeforeMethod(alwaysRun = true)
    public void navigateToFiltersDashboard() {
        sideBarMenu.select(FILTERS.getName());
    }

    @Test
    public void verifyThatUserCannotSearchByFilterNameIfNoFilters() {
        if (noFiltersBlock.isHidden()) {
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
}
