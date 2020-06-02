package io.github.epam.tests;

import org.testng.annotations.Test;

import static io.github.com.entities.LaunchesFilter.ALL_LAUNCHES;
import static io.github.com.entities.LaunchesFilter.LATEST_LAUNCHES;
import static io.github.com.entities.SideBarMenu.LAUNCHES;
import static io.github.com.pages.HomePage.sideBarMenu;
import static io.github.com.pages.LaunchesPage.launchesDropdown;

public class LaunchesPageTest extends TestsBase {
    @Test
    public void verifyThatUserCanChooseLatestLaunches() {
        String expectedLaunchesType = ALL_LAUNCHES.getName();
        sideBarMenu.select(LAUNCHES.getName());
        launchesDropdown.select(expectedLaunchesType);
        launchesDropdown.is().selected(expectedLaunchesType.toUpperCase());
    }

    @Test
    public void verifyThatUserCanChooseAllLaunches() {
        String expectedLaunchesType = LATEST_LAUNCHES.getName();
        sideBarMenu.select(LAUNCHES.getName());
        launchesDropdown.select(expectedLaunchesType);
        launchesDropdown.is().selected(expectedLaunchesType.toUpperCase());
    }
}
