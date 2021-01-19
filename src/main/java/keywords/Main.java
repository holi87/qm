package keywords;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Common;

public class Main extends Common {
    private final Logger log = LogManager.getLogger(Main.class);

    public Main(WebDriver driver) {
        super(driver);
    }

    public Main goToQualityMindsDePage() {
        driver.get(QUALITY_MINDS_DE_URL);
        return this;
    }

    public Main clickKontaktOnTop() {
        waitAndClick(By.xpath("//*[@id='top-menu']//a[contains(text(),'Kontakt')]"));
        log.info("Kontakt menu item is clicked");
        return this;
    }

    public Main acceptCookies() {
        waitAndClick(By.cssSelector(".cc-btn.cc-allow"));
        log.info("cookies are accepted");
        return this;
    }

    public Main clickKontaktAndAnfahrtOnBottom() {
        WebElement menuBottom = presenceOfElementLocated(By.cssSelector("#menu-footer-menu"));
        scrollToWebElement(menuBottom);
        waitAndClick(menuBottom.findElement(By.xpath("//a[contains(text(),'Kontakt & Anfahrt')]")));
        log.info("kontakt on bottom is clicked");
        return this;
    }
}
