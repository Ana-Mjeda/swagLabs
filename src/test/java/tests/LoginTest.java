package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    String username = "standard_user";
    String password = "secret_sauce";
    @Test
    public void login() {

        //Verify the title as Swag Labs
        Assert.assertEquals(loginPage.getLogo().getText(), "Swag Labs");
        Assert.assertEquals(loginPage.getLoginButton().getAttribute("value"), "Login");

        //Login with standard_user & secret_sauce
        loginPage.fillLoginForm(username, password);

        //Verify default filter dropdown is A-Z
        Assert.assertEquals(inventoryPage.getFilterDropdown().getAttribute("value"), "az", "Name (A to Z)");


        //Add the first product to the cart
        inventoryPage.clickAddToCartBackpack();
        
        //Verify the cart badge has 1 product
        Assert.assertEquals(inventoryPage.getShoppingCartBadge().getText(), "1");

        //Add the last product to the cart
        inventoryPage.clickAddToCartShirt();

        //Verify the cart badge value is increased
        Assert.assertEquals(inventoryPage.getShoppingCartBadge().getText(), "2");


        //Remove the first product from the cart
        inventoryPage.clickRemoveBackpack();

        //Verify the cart badge has 1 product
        Assert.assertEquals(inventoryPage.getShoppingCartBadge().getText(), "1");

        //Click on the cart
        inventoryPage.clickShoppingCart();

        //Verify the added product is available
        Assert.assertEquals(cartPage.getCartProduct().getText(), "Test.allTheThings() T-Shirt (Red)");

        //Click on the continue shopping
        cartPage.clickContinueShopping();

        //Change the price filter from low to high
        inventoryPage.selectFilter("Price (low to high)");

        //Verify the price sorted properly
        Assert.assertTrue(inventoryPage.arePricesSorted());



    }
}
