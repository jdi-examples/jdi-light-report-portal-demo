package io.github.epam.reportportal;

import com.epam.reportportal.testng.BaseTestNGListener;
import com.epam.reportportal.testng.ITestNGService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import rp.com.google.common.base.Supplier;
import rp.com.google.common.base.Suppliers;

import java.io.File;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static org.openqa.selenium.OutputType.FILE;

public class CustomReportPortalTestNGListener extends BaseTestNGListener {
    private Logger logger = LogManager.getLogger();

    /* static instance with lazy init */
    public static final Supplier<ITestNGService> SERVICE = Suppliers.memoize(new Supplier<ITestNGService>() {
        @Override
        public CustomTestNGService get() {
            return new CustomTestNGService();
        }
    });

    public CustomReportPortalTestNGListener() {
        super(SERVICE.get());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        File screen = ((TakesScreenshot) getDriver()).getScreenshotAs(FILE);
        logger.info("RP_MESSAGE#FILE#{}#{}", screen.getAbsolutePath(),
            "Screenshot on Failure");
        super.onTestFailure(iTestResult);
    }
}