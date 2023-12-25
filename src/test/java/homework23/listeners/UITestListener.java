package homework23.listeners;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class UITestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(UITestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed successfully: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Тест skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = WebDriverRunner.getWebDriver();

        if (driver != null) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String filePath = "screenshots/" + result.getMethod().getMethodName() + System.currentTimeMillis() + ".png";
            File destinationFile = new File(filePath);
            try {
                FileUtils.copyFile(screenshot, destinationFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.error("Screenshot taken: " + filePath);
        }
    }
}
