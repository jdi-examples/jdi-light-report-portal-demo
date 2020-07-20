package io.github.epam.tests.genrocket;

import io.github.com.util.UserUtils;
import org.testng.annotations.Test;

import static io.github.com.composites.Header.userName;

public class GenRocketLoginTest extends GenRocketTestsBase {

    @Test
    public void verifyThatUserCanLogonAsDefaultUser() {
        userName.assertThat().text(UserUtils.DEFAULT_USER.userName.toUpperCase());
    }
}
