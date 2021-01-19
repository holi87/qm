package tests;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import keywords.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Common;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecondTCStepDefs {

    private WebDriver driver;
    private Main main;
    private Common common;

    @When("qualtiyminds.de home page")
    public void qualtiymindsDeHomePage() {
        main.goToQualityMindsDePage();
    }

    @When("Hover on Portfolio at the top of navigation")
    public void hoverOnPortfolioAtTheTopOfNavigation() {
        common.hoverOnElementBy(By.xpath("//ul[@id='top-menu']//a[text()='Portfolio']"));
    }

    @Then("Verify if submenu is displayed")
    public void verifyIfSubmenuIsDisplayed() {
        assertTrue(driver.findElement(By.xpath("//ul[@id='top-menu']//a[text()='Portfolio']/following-sibling::ul")).isDisplayed());
    }

    @When("Click on Web, Automation & Mobile Testing sub option")
    public void clickOnWebAutomationMobileTestingSubOption() {
        common.moveToElementAndClickIt(By.xpath("//ul[@class='sub-menu']//a[text()='Web, Automation & Mobile Testing']"));

    }

    @Then("Web, Automation & Mobile Testing page is displayed")
    public void webAutomationMobileTestingPageIsDisplayed() {
        common.textToBePresentInElement(common.visibilityOfElementLocated(By.tagName("h1")), "Web, Automation & Mobile Testing");
    }

    @Then("Portfolio item on the top bar menu is highlighted")
    public void portfolioItemOnTheTopBarMenuIsHighlighted() {
        String actualColor = driver.findElement(By.xpath("//ul[@id='top-menu']//a[text()='Portfolio']")).getCssValue("color");
        System.out.println(actualColor);
        assertEquals("rgba(130, 186, 69, 1)", actualColor);
    }

    @When("Click on Mobile tab in Web-Automatiserung - Mobile section")
    public void clickOnMobileTabInSection() {
        common.moveToElementAndClickIt(By.cssSelector("#team-tab-three-title-desktop"));
    }

    @Then("Mobile section content is displayed")
    public void mobileSectionContentIsDisplayed() {
        assertTrue(driver.findElement(By.cssSelector("#team-tab-three-body .tab-body-text")).isDisplayed());
    }

    @Then("Mobile is underlined in grey")
    public void mobileIsUnderlinedInGrey() {
        assertTrue(driver.findElements(
                By.xpath("//div[@id='team-tab-three-title-desktop']/parent::div[contains(@class, 'active-team-tab')]"))
                .size() > 0);
    }

    @Then("Flyer find the bug session button is displayed on the right")
    public void buttonIsDisplayedOnTheRight() {
        assertTrue(driver.findElement(By.cssSelector("#team-tab-three-body .tab-download-button-style")).isDisplayed());
    }

    @Then("The download link for the flyer should be equal to set url")
    public void theDownloadLinkForTheFlyerShouldBeEqualToSetUrl() {
        String actualUrl = common.visibilityOfElementLocated(
                By.cssSelector("#team-tab-three-body .tab-download-button-style")).getAttribute("href");
        String expectedUrl = "https://qualityminds.de/app/uploads/2018/11/Find-The-Mobile-Bug-Session.pdf";
        assertEquals(expectedUrl, actualUrl);
    }

    @Then("File is available via download link")
    public void fileIsAvailableViaDownloadLink() {
    }

    @Given("Webdriver setup")
    public void webdriverSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1366,768");
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        main = new Main(driver);
        common = new Common(driver);
    }

    @After
    public void close() {
        driver.quit();
    }

    @Then("qualityminds.de home page is displayed")
    public void qualitymindsDeHomePageIsDisplayed() {
        main.checkIfQualityMindsPageIsDisplayed();
    }

}
