package io.github.epam;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.settings.JDISettings;
import com.epam.jdi.tools.PropertyReader;
import io.github.com.StaticSite;
import org.apache.commons.lang3.ObjectUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.settings.WebSettings.jdiSetup;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.System.getProperty;

public interface TestsInit {

    static void setRemoteWebDriverIfRequired() {
        String remoteUrl = getProperty("webdriver.remote.url");
        if (remoteUrl != null) {
            logger.toLog("Set remote driver options");
            PropertyReader.loadProperties().setProperty("driver.remote.url", remoteUrl);
          /*  JDISettings.DRIVER.remoteUrl = remoteUrl;
            JDISettings.DRIVER.remoteRun = true;*/
            JDISettings.DRIVER.capabilities.chrome.put("w3c", "true");
            JDISettings.DRIVER.capabilities.chrome.put("platformName",
                    ObjectUtils.defaultIfNull(getProperty("webdriver.platform.name"), "Linux"));
            JDISettings.DRIVER.capabilities.chrome.put("browserVersion", "latest");
            String buildTag = getProperty("build.tag");
            if (buildTag != null) {
                JDISettings.DRIVER.capabilities.chrome.put("build", "build: " + buildTag);
            }
            jdiSetup();
        }
    }

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        JDISettings.DRIVER.domain = PropertyReader.getProperties("test.properties").getProperty("domain");
        setRemoteWebDriverIfRequired();
        WebPage.openSite(StaticSite.class);
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        WebDriverFactory.quit();
    }
}
