package io.github.com;

import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import io.github.com.pages.*;

public class StaticSite {
    @Url("/#login")
    public static LoginPage loginPage;

    @Url("/#test-user_personal/dashboard/%s")
    public static DashboardPage dashboardPage;

    @Url("/#test-user_personal/launches/%s")
    public static LaunchesPage launchesPage;

    @Url("/#test-user_personal/filters/%s")
    public static FiltersPage filtersPage;

    @Url("/#test-user_personal/userdebug/%s")
    public static DebugPage debugPage;
}
