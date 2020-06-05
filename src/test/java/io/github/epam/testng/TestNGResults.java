package io.github.epam.testng;

public enum TestNGResults {
    PASSED("PASSED"),
    SKIPPED("SKIPPED"),
    FAILED("FAILED");

    private final String name;

    TestNGResults(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
