package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

    WebDriver driver;

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }


    By searchBox = By.xpath("//input[@type='search']");
    By productName = By.cssSelector("tr td:nth-child(1)");



    public void searchProduct(String name) {
        driver.findElement(searchBox).sendKeys(name);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }
}
