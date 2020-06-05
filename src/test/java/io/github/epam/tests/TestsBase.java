package io.github.epam.tests;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;

import static io.github.com.StaticSite.dashboardPage;
import static io.github.com.composites.Header.projectSelector;
import static io.github.epam.states.States.shouldBeLoggedIn;

public abstract class TestsBase implements TestsInit {
    protected static final String TEST_USER_PERSONAL = "test-user_personal";

    @BeforeTest(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        dashboardPage.shouldBeOpened();
        projectSelector.select(TEST_USER_PERSONAL);
    }
}
