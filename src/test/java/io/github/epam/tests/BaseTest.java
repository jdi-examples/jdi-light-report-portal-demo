package io.github.epam.tests;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;

import static io.github.com.StaticSite.dashboardPage;
import static io.github.epam.states.States.shouldBeLoggedIn;

public abstract class BaseTest implements TestsInit {
    @BeforeTest(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        dashboardPage.shouldBeOpened();
    }
}
