package io.github.com.entities;

public enum LaunchesFilter {
    ALL_LAUNCHES("All launches"),
    LATEST_LAUNCHES("Latest launches");

    private final String name;

    LaunchesFilter(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
