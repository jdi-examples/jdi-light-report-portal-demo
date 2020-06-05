package io.github.epam.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.debugPage;
import static io.github.com.entities.SideBarMenu.DEBUG;
import static io.github.com.pages.DebugPage.refreshButton;
import static io.github.com.pages.HomePage.sideBarMenu;

public class DebugPageTest extends TestsBase {
    @BeforeMethod(alwaysRun = true)
    public void navigateToFiltersDashboard() {
        sideBarMenu.select(DEBUG.getName());
    }

    @Test
    public void verifyThatUserCanRefreshPage() {
        refreshButton.click();
        debugPage.shouldBeOpened();
    }
}
