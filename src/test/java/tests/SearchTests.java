package tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    protected String searchQuery = "Appium",
            searchArticleQuery = "Selenide";

    @Test
    void successfulSearchTest() {
        step("Type search", () -> {
            mainPage.enterSearchQuery(searchQuery);
        });

        step("Verify content found", () ->
                searchPage.verifyContent());
    }

    @Test
    void checkAnyArticleTitleTest() {

        step("Type search", () -> {
            mainPage.enterSearchQuery(searchArticleQuery);
        });

        step("Click first article", () ->
                searchPage.clickFirstResult());

        step("Verify article title", () ->
                searchPage.verifyArticleTitle(searchArticleQuery));
    }
}