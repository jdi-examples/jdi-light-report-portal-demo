package io.github.com;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import io.github.com.pages.DashboardPage;
import io.github.com.pages.LaunchesPage;
import io.github.com.pages.LoginPage;

@JSite("https://dev.reportportal.io/ui")
public class StaticSite {
    @Url("/#login")
    public static LoginPage loginPage;

    @Url("/#test-user_personal/dashboard")
    public static DashboardPage dashboardPage;

    @Url("/#test-user_personal/launches/all")
    public static LaunchesPage launchesPage;
}
