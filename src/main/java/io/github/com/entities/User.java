package io.github.com.entities;

import com.epam.jdi.tools.DataClass;

public class User extends DataClass<User> {
    public String userName = System.getProperty("report.portal.user");
    public String password = System.getProperty("report.portal.password");

    //    public String userName = "test-user";
    //    public String password = "Fqvq1s0S";
}
