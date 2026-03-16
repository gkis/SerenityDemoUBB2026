package starter.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://automationteststore.com/")
public class SearchForm extends PageObject {
    public static final By SEARCH_FIELD = By.name("filter_keyword");
    public static final By SEARCH_BUTTON = By.cssSelector(".button-in-search");
    public static final By ARTICLE_HEADINGS = By.cssSelector(".fixed .prdocutname");
}