package io.github.com;

import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import io.github.com.pages.*;

public class StaticSite {
    @Url("/#login")
    public static LoginPage loginPage;

    @Url("/#test-user_personal/dashboard/")
    public static DashboardPage dashboardPage;

    @Url("/#test-user_personal/launches/")
    public static LaunchesPage launchesPage;

    @Url("/#test-user_personal/filters/")
    public static FiltersPage filtersPage;

    @Url("/#test-user_personal/userdebug/")
    public static DebugPage debugPage;
}
