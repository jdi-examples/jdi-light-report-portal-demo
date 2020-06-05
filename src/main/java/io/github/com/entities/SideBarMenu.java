package io.github.com.entities;

public enum SideBarMenu {
    DASHBOARD("Dashboard"),
    LAUNCHES("Launches"),
    FILTERS("Filters"),
    DEBUG("Debug");

    private final String name;

    SideBarMenu(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
