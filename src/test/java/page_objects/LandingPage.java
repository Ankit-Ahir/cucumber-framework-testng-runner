package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.xpath("//input[@type='search']");
    By productName = By.cssSelector("h4.product-name");
    By topDeals = By.linkText("Top Deals");

    By increment = By.cssSelector("a.increment");
    By addToCart = By.cssSelector(".product-action button");

    public void searchProduct(String name) {
        driver.findElement(searchBox).sendKeys(name);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getTitleLandingPage() {
        return driver.getTitle();
    }

    public void clickOnTopDealsLink() {
        driver.findElement(topDeals).click();
    }

    public void incrementQuantity(int quantity) {
        int i = quantity - 1;
        while (i > 0) {
            driver.findElement(increment).click();
            i--;
        }

    }

    public void addToCart() {
        driver.findElement(addToCart).click();
    }

}
