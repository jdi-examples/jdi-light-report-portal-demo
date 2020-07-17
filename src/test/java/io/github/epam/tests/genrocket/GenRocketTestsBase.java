package io.github.epam.tests.genrocket;

import io.github.com.util.GenRocketUtils;
import io.github.com.util.UserUtils;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import static io.github.com.StaticSite.dashboardPage;
import static io.github.com.composites.Header.projectSelector;
import static io.github.com.entities.GenRocketPayload.USER_PAYLOAD;
import static io.github.epam.states.States.shouldBeLoggedIn;

@SuppressWarnings("all")
public abstract class GenRocketTestsBase implements TestsInit {

    @BeforeSuite
    public void beforeSuite() throws IOException {
        GenRocketUtils.invokeDataScenario(USER_PAYLOAD);
        UserUtils.DEFAULT_USER = UserUtils.getUsers(USER_PAYLOAD).stream().findFirst().get();
    }

    @BeforeTest(alwaysRun = true)
    public void logInAsTestUser() {
        shouldBeLoggedIn();
        dashboardPage.shouldBeOpened();
    }
}
