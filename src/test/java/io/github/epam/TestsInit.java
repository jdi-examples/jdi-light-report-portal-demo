package io.github.epam;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.settings.JDISettings;
import io.github.com.StaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.System.getProperty;

public interface TestsInit {

    String DEV_ENV = "https://dev.fleetframework.io/ui";

    static void setRemoteWebDriverIfRequired() {
        String remoteUrl = getProperty("webdriver.remote.url");
        if (remoteUrl != null) {
            JDISettings.DRIVER.remoteUrl = remoteUrl;
            JDISettings.DRIVER.remoteRun = true;
            JDISettings.DRIVER.capabilities.chrome.put("w3c", "true");
            JDISettings.DRIVER.capabilities.chrome.put("platformName", "Windows");
            JDISettings.DRIVER.capabilities.chrome.put("browserVersion", "latest");
            String buildTag = getProperty("build.tag");
            if (buildTag != null) {
                JDISettings.DRIVER.capabilities.chrome.put("build", "build: " + buildTag);
            }
        }
    }

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        JDISettings.DRIVER.domain = System.getProperty("env", DEV_ENV);
        setRemoteWebDriverIfRequired();
        WebPage.openSite(StaticSite.class);
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        WebDriverFactory.quit();
    }
}
