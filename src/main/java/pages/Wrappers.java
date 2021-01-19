package pages;

import config.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Root class for pages, has only wrappers.
 */
public class Wrappers {
    protected final WebDriver driver;
    protected final WebDriverWait webDriverWait;

    /**
     * Constructor for main attrbutes using in framework
     * Has initialization page factory elements
     * Sets timer on webDriverWait object
     *
     * @param driver WebDriver for all methods
     */
    public Wrappers(WebDriver driver) {
        this.driver = driver;
        ConfigurationReader cfg = new ConfigurationReader();
        webDriverWait = new WebDriverWait(driver, cfg.getWebdriverwaitTime());
    }

    /**
     * wait until text to be prestent in WebElement
     *
     * @param webElement WebElement to check text
     * @param text       text to be checked in WebElement
     * @return true if text is in element
     */
    protected Boolean textToBePresentInElement(WebElement webElement, String text) {
        return webDriverWait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    /**
     * Wait until element is presence, then wait until same element is clickable.
     *
     * @param by uses By object to define element to check
     * @return WebElement which is presence and clickable
     */

    protected WebElement isClickable(By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Wait until element is presence, then wait until same element is clickable.
     *
     * @param webElement uses WebElement to check
     * @return WebElement which is presence and clickable
     */
    protected WebElement isClickable(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * checking actual URL with expected one
     *
     * @param expectedUrl expected url
     * @return true if expected url is same as actual url
     */
    protected Boolean urlToBe(String expectedUrl) {
        return webDriverWait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    /**
     * get actual url
     *
     * @return actual url
     */
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * checking that alert is present on page
     */
    protected void alertIsPresent() {
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * checking visibilyty of element located by
     *
     * @param by By object
     * @return webelement with isDisplayed == true
     */
    protected WebElement visibilityOfElementLocated(By by) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * gets actions object
     *
     * @return Actions object
     */
    protected Actions getActions() {
        return new Actions(driver);
    }

    /**
     * Checking that element is in DOM
     *
     * @param by By object
     * @return WebElement
     */
    protected WebElement presenceOfElementLocated(By by) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
