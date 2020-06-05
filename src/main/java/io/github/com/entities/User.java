package io.github.com.entities;

import com.epam.jdi.tools.DataClass;

public class User extends DataClass<User> {
    public String userName;
    public String password;

    public User() {
        this.userName = System.getProperty("report.portal.user");
        this.password = System.getProperty("report.portal.password");
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
