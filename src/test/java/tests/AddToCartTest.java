package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest{

    @Test
    public void addToCart(){

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
        Assert.assertEquals(inventoryPage.getShoppingCartBadge().getText(), "2");}
}