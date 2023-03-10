package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
    private WebElement filterDropdown;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement addToCartBackpack;

    @FindBy(xpath = "//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")
    private WebElement addToCartShirt;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    private WebElement shoppingCartBadge;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement shoppingCart;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-backpack\"]")
    private WebElement removeBackpack;

    public InventoryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getFilterDropdown() {
        return filterDropdown;
    }

    public void clickAddToCartBackpack() {
        addToCartBackpack.click();
    }

    public WebElement getShoppingCartBadge() {
        return shoppingCartBadge;
    }

    public void clickAddToCartShirt() {
        addToCartShirt.click();
    }

    public void clickRemoveBackpack() {
        removeBackpack.click();
    }

    public void clickShoppingCart() {
        shoppingCart.click();
    }

    public void selectFilter(String filterName) {
        Select filter = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        filter.selectByVisibleText(filterName);
    }


    public boolean arePricesSorted() {
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        for (int i = 0; i < prices.size() - 1; i++) {
            double price = Double.parseDouble(prices.get(i).getText().substring(1));
            double nextPrice = Double.parseDouble(prices.get(i + 1).getText().substring(1));
            // TODO preci tipove u javi
            if (price > nextPrice) {
                return false;
            }
        }
        return true;
    }
}
