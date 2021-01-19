package utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import tests.kdt.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class Watcher implements TestWatcher {
    private final static String DESTINATION_PATH = "src\\main\\resources\\screenshots\\";
    private final Logger log = LogManager.getLogger();

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        WebDriver driver = ((BaseTest) context.getRequiredTestInstance()).driver;
        log.error("Error screenshot on scenario: " + context.getDisplayName() + ", error type: " + cause.getClass().getSimpleName());
        screenshoot((TakesScreenshot) driver, generateFileName("fail", ".png"));
        teardown(driver);
    }


    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        teardown(((BaseTest) context.getRequiredTestInstance()).driver);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        WebDriver driver = ((BaseTest) context.getRequiredTestInstance()).driver;
        log.info("Success screenshot on scenario: " + context.getDisplayName() + " after success");
        screenshoot((TakesScreenshot) driver, generateFileName("success", ".png"));
        teardown(((BaseTest) context.getRequiredTestInstance()).driver);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        teardown(((BaseTest) context.getRequiredTestInstance()).driver);
    }

    public String generateFileName(String cause, String extension) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy__HH_mm_ss.SSS");
        String strDate = formatter.format(new Date());
        return cause + "_" + strDate + extension;
    }

    @Attachment(type = "image/png")
    private byte[] screenshoot(TakesScreenshot driver, String fileName) {

        File scrFile = driver.getScreenshotAs(OutputType.FILE);
        try {
            File currPath = new File(DESTINATION_PATH + fileName);
            log.info("Screenshot at: " + currPath.toString());
            FileHandler.copy(scrFile, currPath);
            return FileUtils.readFileToByteArray(scrFile);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private void teardown(WebDriver driver) {
        driver.quit();
    }
}
