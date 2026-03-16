package starter.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import starter.pageobjects.ProductPage;

public class ProductSteps extends UIInteractionSteps {

    ProductPage productPage;

    @Step("Check the search results")
    public String getProductName() {
        return find(ProductPage.PRODUCT_NAME).getText();
    }
}
