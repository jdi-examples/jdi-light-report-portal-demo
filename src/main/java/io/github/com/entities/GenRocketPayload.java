package io.github.com.entities;

public enum GenRocketPayload {
    USER_PAYLOAD("/userScenarioPayload.json", "User has not been created");

    private final String name;
    private final String error;

    GenRocketPayload(final String name, final String error) {
        this.name = name;
        this.error = error;
    }

    public String getName() {
        return name;
    }

    public String getError() {
        return error;
    }
}
