package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class SearchPage {
    protected ElementsCollection
            searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title")),
    textView = $$(className("android.widget.TextView"));


    public void verifyContent() {
        searchResults.shouldHave(sizeGreaterThan(0));
    }

    public void clickFirstResult() {
        searchResults.first().click();
    }

    public void verifyArticleTitle(String titleValue) {
        textView.findBy(text(titleValue))
                .shouldBe(visible);
    }


}
