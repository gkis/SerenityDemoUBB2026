package starter.acceptancetests;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import starter.actions.NavigateSteps;
import starter.actions.ProductSteps;
import starter.actions.SearchSteps;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class TestWhenSearchingForTerms {

    @Steps
    NavigateSteps navigate;

    @Steps
    SearchSteps search;

    @Steps
    ProductSteps product;

    @Test
    @DisplayName("Should be able to search for shirts")
    void searchForShirts() {
        navigate.opensTheHomePage();
        search.searchForTerm("shirt");
        assertThat(search.getSearchResults()).allMatch(title -> title.toLowerCase().contains("shirt"));
    }

    @ParameterizedTest
    @DisplayName("Should be able to search for products and return multiple results")
    @CsvSource({
            "shirt, 4",
            "spray, 6",
            "cream, 4",
            "shoe, 4"
    })
    void searchForMultipleProducts(String term, String productsNr) {
        navigate.opensTheHomePage();
        search.searchForTerm(term);
        assertThat(search.getSearchResults()).hasSize(Integer.parseInt(productsNr));
    }

    @Test
    @DisplayName("Result page product should mention the search term")
    void searchForSpecificProduct() {
        navigate.opensTheHomePage();
        search.searchForTerm("Fruit of the Loom T-Shirts 5 Pack");
        assertThat(product.getProductName()).containsIgnoringCase("Fruit of the Loom T-Shirts 5 Pack");
    }

}