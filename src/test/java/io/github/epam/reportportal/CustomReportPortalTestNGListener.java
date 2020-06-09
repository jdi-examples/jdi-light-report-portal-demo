package io.github.epam.reportportal;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
    import org.apache.logging.log4j.LogManager;
    import org.apache.logging.log4j.Logger;
    import org.openqa.selenium.TakesScreenshot;
    import org.testng.ITestResult;

    import java.io.File;

    import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
    import static org.openqa.selenium.OutputType.FILE;

public class CustomReportPortalTestNGListener extends ReportPortalTestNGListener {

    private Logger logger = LogManager.getLogger();

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        File screen = ((TakesScreenshot) getDriver()).getScreenshotAs(FILE);
        logger.info("RP_MESSAGE#FILE#{}#{}", screen.getAbsolutePath(),
            "Screenshot on Failure");
        super.onTestFailure(iTestResult);
    }
}