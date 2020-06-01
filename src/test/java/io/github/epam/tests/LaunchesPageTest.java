package io.github.epam.tests;

import io.github.com.entities.LaunchesFilter;
import org.testng.annotations.Test;

import static io.github.com.composites.SideBar.launchesButton;
import static io.github.com.pages.LaunchesPage.launchesDropdown;

public class LaunchesPageTest extends BaseTest {
    @Test
    public void verifyThatUserCanChooseLatestLaunches() {
        String expectedLaunchesType = LaunchesFilter.ALL_LAUNCHES.getName();
        launchesButton.click();
        launchesDropdown.select(expectedLaunchesType);
        launchesDropdown.is().selected(expectedLaunchesType.toUpperCase());
    }

    @Test
    public void verifyThatUserCanChooseAllLaunches() {
        String expectedLaunchesType = LaunchesFilter.LATEST_LAUNCHES.getName();
        launchesButton.click();
        launchesDropdown.select(expectedLaunchesType);
        launchesDropdown.is().selected(expectedLaunchesType.toUpperCase());
    }
}
