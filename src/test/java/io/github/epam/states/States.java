package io.github.epam.states;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.com.entities.User;
import io.qameta.allure.Step;

import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static io.github.com.StaticSite.loginPage;
import static io.github.com.util.UserUtils.DEFAULT_USER;

public class States {
    @Step
    public static void shouldBeLoggedIn() {
        shouldBeLoggedIn(DEFAULT_USER);
    }

    @Step
    public static void shouldBeLoggedIn(User user) {
        String url = WebPage.getUrl();
        if (!url.contains(DRIVER.domain) || url.contains("issue")) {
            openUrl(DRIVER.domain);
        }
        loginPage.open();
        login(user);
    }

    @Step
    private static void login(User user) {
        loginPage.loginForm.loginAs(user);
    }

}
