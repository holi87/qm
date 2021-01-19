package keywords;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Common;

public class Kontakt extends Common {
    private final Logger log = LogManager.getLogger(Kontakt.class);

    public Kontakt(WebDriver driver) {
        super(driver);
    }

    /**
     * checks if page is displayed (checks just H1)
     *
     * @return Kontakt for fluent writting
     */
    public Kontakt pageIsDisplayed() {
        textToBePresentInElement(visibilityOfElementLocated(By.tagName("h1")), "Kontakt & Anfahrt");
        log.info("page is displayed");
        // here could be inserted something that checks full load of page, but it looks too trivial
        return this;
    }

    /**
     * checks if page contains email
     *
     * @param email String with email
     * @return Kontakt for fluent writting
     */
    public Kontakt shouldContainsEmail(String email) {
        textToBePresentInElement(visibilityOfElementLocated(By.tagName("body")), email);
        log.info("email is on page");
        return this;
    }

    /**
     * method for saving current url to String variable
     *
     * @return current url
     */
    public String saveUrl() {
        log.info("saving url");
        return getCurrentUrl();
    }

    /**
     * navigate back to qualityminds.de
     *
     * @return Kontakt for fluent writting
     */
    public Kontakt navigateBackToMainQMPage() {
//        driver.navigate().back();
        // can choose one of methods, second one is more stricte with test case
        new Main(driver).goToQualityMindsDePage();
        log.info("back on the Quality Minds page");
        return this;
    }
}
