package io.github.com.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.User;


public class LoginForm extends Form<User> {

    @UI("//div[contains(@class, 'loginForm__login')]//input")
    //@UI("[class*='loginForm__login-field'] input")
    public TextField name;
    @UI("//div[contains(@class, 'loginForm__password')]//input")
    public TextField password;
    @UI("//div[contains(@class, 'loginForm')]/button")
    public Button loginButton;
}


