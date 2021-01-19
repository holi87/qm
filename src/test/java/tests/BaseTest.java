package tests;

import config.ConfigurationReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Watcher;

import java.util.concurrent.TimeUnit;

@ExtendWith(Watcher.class)
public class BaseTest {

    private final ConfigurationReader cfg = new ConfigurationReader();
    public WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1366,768");
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(cfg.getPageloadTime(), TimeUnit.SECONDS);
    }
}
