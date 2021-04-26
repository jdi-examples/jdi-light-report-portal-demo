package io.github.epam;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.settings.JDISettings;
import com.epam.jdi.tools.PropertyReader;
import io.github.com.StaticSite;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.PropertiesConfigurationLayout;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.lang3.ObjectUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.System.getProperty;

public interface TestsInit {

    static void setRemoteWebDriverIfRequired() throws IOException, ConfigurationException {
        String remoteUrl = getProperty("webdriver.remote.url");
        if (remoteUrl != null) {
            logger.toLog("Set remote driver options");
            addTestProperty("driver.remote.url", remoteUrl);
            JDISettings.DRIVER.capabilities.chrome.put("w3c", "true");
            JDISettings.DRIVER.capabilities.chrome.put("platformName",
                    ObjectUtils.defaultIfNull(getProperty("webdriver.platform.name"), "Linux"));
            JDISettings.DRIVER.capabilities.chrome.put("browserVersion", "latest");
            String buildTag = getProperty("build.tag");
            if (buildTag != null) {
                JDISettings.DRIVER.capabilities.chrome.put("build", "build: " + buildTag);
            }
        }
    }

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        JDISettings.DRIVER.domain = PropertyReader.getProperties("test.properties").getProperty("domain");
        try {
            setRemoteWebDriverIfRequired();
        } catch (ConfigurationException | IOException e) {
            logger.error("Error during setting of remote web driver properties");
        }
        WebPage.openSite(StaticSite.class);
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        WebDriverFactory.quit();
    }

    static void addTestProperty(String key, String value) throws IOException, ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration();
        PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout();
        config.setLayout(layout);
        File propertiesFile = new File(Objects.requireNonNull(
                TestsInit.class.getClassLoader().getResource(JDISettings.COMMON.testPropertiesPath)).getFile());
        layout.load(config, new FileReader(propertiesFile));

        config.setProperty(key, value);
        layout.save(config, new FileWriter(propertiesFile));
    }
}
