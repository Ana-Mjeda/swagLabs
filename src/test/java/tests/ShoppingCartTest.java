package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest{

    @Test
    public void verifyIfProductInCart(){

        loginPage.fillLoginForm(username, password);
        inventoryPage.clickAddToCartBackpack();
        inventoryPage.clickAddToCartShirt();
        inventoryPage.clickRemoveBackpack();

        //Click on the cart
        inventoryPage.clickShoppingCart();

        //Verify the added product is available
        Assert.assertEquals(cartPage.getCartProduct().getText(), "Test.allTheThings() T-Shirt (Red)");
    }

}
