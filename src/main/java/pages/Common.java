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

    protected void waitAndClick(WebElement webElement) {
        isClickable(webElement).click();
    }

    /**
     * used only for visual check on page in debuging mode
     */
    public void stopper() {
        alertIsPresent();
    }

    /**
     * chekcs if url is as expected
     *
     * @param url expected url as a String
     */
    public void urlShouldBe(String url) {
        urlToBe(url);
    }

    protected void scrollToWebElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }
}