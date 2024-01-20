package step_definitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import page_objects.CheckoutPage;
import page_objects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
    public CheckoutPage checkoutPage;
    TestContextSetup testContextSetup;
    String productNameCheckoutPage;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPageObject();
    }

    @Then("validate the product in checkout page and then proceed to checkout")
    public void validate_the_product_in_checkout_page_and_then_proceed_to_checkout() {
        checkoutPage.clickOnCartBag();
        productNameCheckoutPage = checkoutPage.getProductName().split("-")[0].trim();
//        System.out.println(checkoutPage.getProductName());
        Assert.assertEquals(testContextSetup.productNameLandingPage, productNameCheckoutPage);
        checkoutPage.proceedToCheckout();
    }

    @Then("verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
    }

}
