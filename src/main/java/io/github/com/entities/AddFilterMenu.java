package io.github.com.entities;

public enum AddFilterMenu {
    LAUNCH_NAME("Launch name"),
    LAUNCH_NUMBER("Launch number");

    private final String name;

    AddFilterMenu(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
