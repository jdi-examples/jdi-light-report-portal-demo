package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.composites.LoginForm;

public class LoginPage extends WebPage {
    @UI("form[class*=loginForm]")
    public static LoginForm loginForm;
}
