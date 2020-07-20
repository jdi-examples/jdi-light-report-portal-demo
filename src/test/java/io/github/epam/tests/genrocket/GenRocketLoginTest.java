package io.github.epam.tests.genrocket;

import io.github.com.entities.User;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.dashboardPage;
import static io.github.com.composites.Header.userName;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class GenRocketLoginTest extends GenRocketTestsBase {

    @Test(dataProvider = "getUser")
    public void verifyThatUserCanLogonAsDefaultUser(User user) {
        shouldBeLoggedIn(user);
        dashboardPage.shouldBeOpened();
        userName.assertThat().text(user.userName.toUpperCase());
    }
}
