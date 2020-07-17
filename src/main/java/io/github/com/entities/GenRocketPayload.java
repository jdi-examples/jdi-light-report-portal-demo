package io.github.com.entities;

public enum GenRocketPayload {
    USER_PAYLOAD("/userScenarioPayload.json",  "users.json", "User has not been created");

    private final String name;
    private final String outFile;
    private final String error;

    GenRocketPayload(final String name, final String outFile, final String error) {
        this.name = name;
        this.error = error;
        this.outFile = outFile;
    }

    public String getOutFile() {
        return outFile;
    }

    public String getName() {
        return name;
    }

    public String getError() {
        return error;
    }
}
