package io.github.com;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.forms.LoginForm;
import io.github.com.pages.HomePage;
import io.github.com.pages.LoginPage;


@JSite("https://dev.reportportal.io/ui")
public class StaticSite {

    @Url("/#login")
    public static LoginPage loginPage;

    @Url("/#")
    public static HomePage homePage;

    @UI("//form[contains(@class, 'loginForm')]")
    public static LoginForm loginForm;
}
