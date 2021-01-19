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

    public Kontakt pageIsDisplayed() {
        textToBePresentInElement(visibilityOfElementLocated(By.tagName("h1")), "Kontakt & Anfahrt");
        log.info("page is displayed");
        // here could be inserted something that checks full load of page, but it looks too trivial
        return this;
    }

    public Kontakt shouldContainsEmail(String email) {
        textToBePresentInElement(visibilityOfElementLocated(By.tagName("body")), email);
        log.info("email is on page");
        return this;
    }

    public String saveUrl() {
        log.info("saving url");
        return getCurrentUrl();
    }

    public Kontakt navigateBackToMainQMPage() {
//        driver.navigate().back();
        // can choose one of methods, second one is more stricte with test case
        new Main(driver).goToQualityMindsDePage();
        log.info("back on the Quality Minds page");
        return this;
    }
}
