package io.github.epam.test.data;

import io.github.com.entities.User;

public class UserUtils {
    public static final User DEFAULT_USER = new User().set(u -> {
        u.userName = "default";
        u.password = "1q2w3e";
    });
}
