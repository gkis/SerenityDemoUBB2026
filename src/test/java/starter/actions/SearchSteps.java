package starter.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.JavascriptExecutor;
import starter.pageobjects.SearchForm;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SearchSteps extends UIInteractionSteps {

    SearchForm searchForm;

    @Step("User searches for '{0}'")
    public void searchForTerm(String searchTerm) {
        find(SearchForm.SEARCH_FIELD).sendKeys(searchTerm);
        find(SearchForm.SEARCH_BUTTON).click();

        /*withTimeoutOf(Duration.ofSeconds(10))
                .waitFor(presenceOfElementLocated(SearchForm.ARTICLE_HEADINGS));*/

        //wait until page loads
        withTimeoutOf(Duration.ofSeconds(10)).waitForCondition().until(
                driver -> ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    @Step("Check the search results")
    public List<String> getSearchResults() {
        return findAll(SearchForm.ARTICLE_HEADINGS).texts();
    }
}
