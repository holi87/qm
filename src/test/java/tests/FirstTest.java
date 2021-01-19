package tests;

import keywords.Kontakt;
import keywords.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTest extends BaseTest {
    private final static String E_MAIL = "hello@qualityminds.de";
    private Main main;
    private Kontakt kontakt;

    @BeforeEach
    public void start() {
        main = new Main(driver);
        kontakt = new Kontakt(driver);
    }

    @Test
    @DisplayName("test case 1")
    public void checkKontaktPage() {
        main
                .goToQualityMindsDePage()
                .acceptCookies()
                .clickKontaktOnTop();
        kontakt
                .pageIsDisplayed()
                .shouldContainsEmail(E_MAIL);

        String kontaktUrl = kontakt.saveUrl();

        kontakt.navigateBackToMainQMPage();

        main
                .clickKontaktAndAnfahrtOnBottom();
        kontakt
                .pageIsDisplayed()
                .shouldContainsEmail(E_MAIL)
                .urlShouldBe(kontaktUrl);

    }
}
