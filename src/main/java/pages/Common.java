package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Common extends Wrappers {
    protected final static String QUALITY_MINDS_DE_URL = "https://qualityminds.de/";

    public Common(WebDriver driver) {
        super(driver);
    }


    /**
     * wait until element is clickable, then making click on it.
     *
     * @param by uses By object to define element for click on
     */
    protected void waitAndClick(By by) {
        isClickable(by).click();
    }

    /**
     * wait until element is clickable, then making click on it.
     *
     * @param webElement uses WebElement object to define element for click on
     */
    protected void waitAndClick(WebElement webElement) {
        isClickable(webElement).click();
    }

    /**
     * chekcs if url is as expected
     *
     * @param url expected url as a String
     */
    public void urlShouldBe(String url) {
        urlToBe(url);
    }

    /**
     * method using JS executor for scrolling to webelement
     *
     * @param webElement which is target for scrolling
     */
    protected void scrollToWebElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public void hoverOnElementBy(By by) {
        getActions().moveToElement(visibilityOfElementLocated(by)).build().perform();
    }

    public void moveToElementAndClickIt(By by) {
        getActions().moveToElement(visibilityOfElementLocated(by)).click().build().perform();
    }
}