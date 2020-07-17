package io.github.epam.states;

import com.epam.jdi.light.elements.composite.WebPage;
import io.qameta.allure.Step;

import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static io.github.com.StaticSite.loginPage;
import static io.github.com.util.UserUtils.DEFAULT_USER;

public class States {
    @Step
    public static void shouldBeLoggedIn() {
        String url = WebPage.getUrl();
        if (!url.contains(DRIVER.domain) || url.contains("issue")) {
            openUrl(DRIVER.domain);
        }
        loginPage.open();
        login();
    }

    @Step
    private static void login() {
        loginPage.loginForm.loginAs(DEFAULT_USER);
    }
}
