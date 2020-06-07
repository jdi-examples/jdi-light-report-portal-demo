package io.github.epam.tests;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.homePage;
import static io.github.com.pages.HomePage.logoButton;
import static io.github.com.pages.HomePage.userName;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static io.github.epam.test.data.UserUtils.DEFAULT_USER;

public class BaseTest implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        homePage.shouldBeOpened();
    }

    @Test
    public void baseTest() {
        logoButton.is().notVisible();
        userName.is().equals(DEFAULT_USER.name);
        throw new RuntimeException();
    }
}
