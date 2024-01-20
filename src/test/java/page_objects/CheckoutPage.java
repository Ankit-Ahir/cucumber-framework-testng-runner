package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartBag = By.cssSelector("[alt='Cart']");
    By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    By promoBtn = By.cssSelector(".promoBtn");
    By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

    By productName = By.cssSelector("p.product-name");

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public void clickOnCartBag() {
        driver.findElement(cartBag).click();
    }
    public void proceedToCheckout() {
        driver.findElement(checkOutButton).click();
    }

    public Boolean VerifyPromoBtn() {
        return driver.findElement(promoBtn).isDisplayed();
    }

    public Boolean VerifyPlaceOrder() {
        return driver.findElement(placeOrder).isDisplayed();
    }
}
