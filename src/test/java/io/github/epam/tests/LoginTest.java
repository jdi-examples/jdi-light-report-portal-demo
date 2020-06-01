package io.github.epam.tests;

import org.testng.annotations.Test;

import static io.github.com.composites.Header.menuIcon;
import static io.github.com.composites.Header.userName;
import static io.github.epam.test.data.UserUtils.DEFAULT_USER;

public class LoginTest extends BaseTest {
    @Test
    public void verifyThatUserCanLogonAsDefaultUser() {
        menuIcon.is().displayed();
        userName.assertThat().text(DEFAULT_USER.userName.toUpperCase());
    }
}
