package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTest extends BaseTest{

    @Test
    public void sortPriceFromLowToHigh(){

        loginPage.fillLoginForm(username, password);

        //Change the price filter from low to high
        inventoryPage.selectFilter("Price (low to high)");

        //Verify the price sorted properly
        Assert.assertTrue(inventoryPage.arePricesSorted());
    }
}
