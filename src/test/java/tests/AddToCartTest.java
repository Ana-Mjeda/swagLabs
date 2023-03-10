package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest{

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.fillLoginForm(username, password);
    }
    @Test
    public void addToCart(){

        //Verify default filter dropdown is A-Z
        Assert.assertEquals(inventoryPage.getFilterDropdown().getAttribute("value"), "az", "Name (A to Z)");

        //Add the first product to the cart
        inventoryPage.clickAddToCartBackpack();

        //Verify the cart badge has 1 product
        Assert.assertEquals(inventoryPage.getShoppingCartBadge().getText(), "1");

        //Add the last product to the cart
        inventoryPage.clickAddToCartShirt();

        //Verify the cart badge value is increased
        Assert.assertEquals(inventoryPage.getShoppingCartBadge().getText(), "2");}

    @Test
    public void removeFromCart(){

        inventoryPage.clickAddToCartBackpack();
        inventoryPage.clickAddToCartShirt();

        //Remove the first product from the cart
        inventoryPage.clickRemoveBackpack();

        //Verify the cart badge has 1 product
        Assert.assertEquals(inventoryPage.getShoppingCartBadge().getText(), "1");
    }
}
