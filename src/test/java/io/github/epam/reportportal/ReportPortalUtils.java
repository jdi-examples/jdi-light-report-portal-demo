package io.github.epam.reportportal;

public class ReportPortalUtils {

    private ReportPortalUtils() {}

    public static String camelCaseToSentence(String camelCase) {
        String testName = camelCase.replaceAll(
            String.format("%s|%s|%s",
                "(?<=[A-Z])(?=[A-Z][a-z])",
                "(?<=[^A-Z])(?=[A-Z])",
                "(?<=[A-Za-z])(?=[^A-Za-z])"
            ),
            " "
        ).toLowerCase();
        return testName.substring(0, 1).toUpperCase() + testName.substring(1).toLowerCase();
    }
}
