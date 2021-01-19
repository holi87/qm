package tests;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import keywords.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SecondTCStepDefs {

    private WebDriver driver;
    private Main main;

    @When("qualtiyminds.de home page")
    public void qualtiymindsDeHomePage() {
        main.goToQualityMindsDePage();
    }

    @When("Hover on Portfolio at the top of navigation")
    public void hoverOnPortfolioAtTheTopOfNavigation() {
    }

    @Then("Verify if submenu is displayed")
    public void verifyIfSubmenuIsDisplayed() {
    }

    @When("Click on Web, Automation & Mobile Testing sub option")
    public void clickOnWebAutomationMobileTestingSubOption() {
    }

    @Then("Web, Automation & Mobile Testing page is displayed")
    public void webAutomationMobileTestingPageIsDisplayed() {
    }

    @Then("Portfolio item on the top bar menu is highlighted")
    public void portfolioItemOnTheTopBarMenuIsHighlighted() {
    }

    @When("Click on Mobile tab in {string} section")
    public void clickOnMobileTabInSection(String arg0) {
    }

    @Then("Mobile section content is displayed")
    public void mobileSectionContentIsDisplayed() {
    }

    @Then("Mobile is underlined in grey")
    public void mobileIsUnderlinedInGrey() {
    }

    @Then("{string} button is displayed on the right")
    public void buttonIsDisplayedOnTheRight(String arg0) {
    }

    @Then("The download link for the flyer should be equal to set url")
    public void theDownloadLinkForTheFlyerShouldBeEqualToSetUrl() {
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
