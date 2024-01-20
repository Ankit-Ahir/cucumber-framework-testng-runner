package step_definitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import page_objects.LandingPage;
import page_objects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefinition {
    TestContextSetup testContextSetup;
    String productNameOffersPage;

    public OffersPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("^user search the product with shortname (.+) in offers page$")
    public void user_search_the_product_with_shortname_in_offers_page(String shortname) throws InterruptedException {
        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPageObject();
        offersPage.searchProduct(shortname);
        Thread.sleep(2000);
        productNameOffersPage = offersPage.getProductName();

    }

    public void switchToOffersPage() {
        //if switched to offer page -> skip below part
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPageObject();
        landingPage.clickOnTopDealsLink();
        testContextSetup.genericUtils.switchToChildWindow();
        //explicit wait, parse string
    }


    @Then("validate product name in offers page matches with landing page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(productNameOffersPage, testContextSetup.productNameLandingPage);
    }
}
