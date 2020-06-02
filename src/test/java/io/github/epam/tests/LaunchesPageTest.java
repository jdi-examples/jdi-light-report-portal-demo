package io.github.epam.tests;

import io.github.com.entities.LaunchesFilter;
import io.github.com.entities.SideBarMenu;
import org.testng.annotations.Test;

import static io.github.com.pages.HomePage.sideBarMenu;
import static io.github.com.pages.LaunchesPage.launchesDropdown;

public class LaunchesPageTest extends TestsBase {
    @Test
    public void verifyThatUserCanChooseLatestLaunches() {
        String expectedLaunchesType = LaunchesFilter.ALL_LAUNCHES.getName();
        sideBarMenu.select(SideBarMenu.LAUNCHES.getName());
        launchesDropdown.select(expectedLaunchesType);
        launchesDropdown.is().selected(expectedLaunchesType.toUpperCase());
    }

    @Test
    public void verifyThatUserCanChooseAllLaunches() {
        String expectedLaunchesType = LaunchesFilter.LATEST_LAUNCHES.getName();
        sideBarMenu.select(SideBarMenu.LAUNCHES.getName());
        launchesDropdown.select(expectedLaunchesType);
        launchesDropdown.is().selected(expectedLaunchesType.toUpperCase());
    }
}
