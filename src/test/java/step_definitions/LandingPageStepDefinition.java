package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page_objects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPageObject();
    }

    @Given("user is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {
        Assert.assertEquals(landingPage.getTitleLandingPage(), "GreenKart - veg and fruits kart");
    }

    @When("^user search the product with shortname (.+) and extract the actual name of product$")
    public void user_search_the_product_with_shortname_and_extract_the_actual_name_of_product(String shortname) throws InterruptedException {
        landingPage.searchProduct(shortname);
        Thread.sleep(2000);
        testContextSetup.productNameLandingPage = landingPage.getProductName().split("-")[0].trim();
    }

    @When("added {string} items of the selected product to the cart")
    public void added_items_of_the_selected_product_to_the_cart(String quantity) {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
    }
}
