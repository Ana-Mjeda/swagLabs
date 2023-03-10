package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

    @FindBy (xpath = "//*[@id=\"item_3_title_link\"]")
    private WebElement cartProduct;

    @FindBy (id = "continue-shopping")
    private WebElement continueShoppingButton;

    public CartPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getCartProduct(){
        return cartProduct;
    }

    public void clickContinueShopping(){
        continueShoppingButton.click();
    }
}
