package page_objects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public WebDriver driver;
    public LandingPage landingPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPageObject() {
        landingPage = new LandingPage(driver);
        return landingPage;
    }

    public OffersPage getOffersPageObject() {
        return new OffersPage(driver);
    }

    public CheckoutPage getCheckoutPageObject() {
        return new CheckoutPage(driver);
    }
}
