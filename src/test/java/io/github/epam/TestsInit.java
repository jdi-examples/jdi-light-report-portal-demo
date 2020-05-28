package io.github.epam;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.settings.JDISettings;
import io.github.com.StaticSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.settings.WebSettings.logger;

public interface TestsInit {

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        String remoteUrl = System.getProperty("webdriver.remote.url");
        if (remoteUrl != null) {
            JDISettings.DRIVER.remoteUrl = remoteUrl;
            JDISettings.DRIVER.capabilities.chrome.put("w3c", "true");
            JDISettings.DRIVER.capabilities.chrome.put("platformName", "Linux");
            JDISettings.DRIVER.capabilities.chrome.put("browserVersion", "latest");
            // JDISettings.DRIVER.capabilities.chrome.put("sauce:options", sauceOptions);
        }
        openSite(StaticSite.class);
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        WebDriverFactory.quit();
    }
}
