package io.github.epam.tests;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static io.github.com.composites.Header.menuIcon;
import static io.github.com.composites.Header.userName;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static io.github.epam.test.data.UserUtils.DEFAULT_USER;

public class BaseTest implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
    }

    @Test
    public void baseTest() {
        menuIcon.is().displayed();
        userName.assertThat().text(DEFAULT_USER.userName.toUpperCase());
    }

    @Test
    public void baseTestOne() {
        menuIcon.is().displayed();
        userName.assertThat().text(DEFAULT_USER.userName.toUpperCase());
    }

    @AfterMethod
    public void after() {
        killAllSeleniumDrivers();
    }
}
