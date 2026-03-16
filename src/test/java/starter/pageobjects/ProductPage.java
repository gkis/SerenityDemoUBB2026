package starter.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductPage extends PageObject {
    public static final By PRODUCT_NAME = By.cssSelector(".productname span");
    public static final By PRODUCT_PRICE = By.cssSelector(".productfilneprice");
}