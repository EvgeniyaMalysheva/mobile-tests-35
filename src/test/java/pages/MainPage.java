package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {
    protected SelenideElement searchField = $(accessibilityId("Search Wikipedia")),
            toSearchField = $(id("org.wikipedia.alpha:id/search_src_text"));

    public void enterSearchQuery(String searchValue) {
        searchField.click();
        toSearchField.sendKeys(searchValue);
    }
}
