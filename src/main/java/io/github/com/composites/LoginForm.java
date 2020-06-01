package io.github.com.composites;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.User;

public class LoginForm extends Form<User> {
    @UI("input[type='text']")
    public static TextField userName;

    @UI("input[type='password']")
    public static TextField password;

    @UI("button[type='submit']")
    public static Button loginButton;
}


