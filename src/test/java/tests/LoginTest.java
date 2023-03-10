package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login() {

        //Verify the title as Swag Labs
        Assert.assertEquals(loginPage.getLogo().getText(), "Swag Labs");
        Assert.assertEquals(loginPage.getLoginButton().getAttribute("value"), "Login");

        //Login with standard_user & secret_sauce
        loginPage.fillLoginForm(username, password);
    }

    @Test
    public void verifyFilter() {
        //Verify default filter dropdown is A-Z

        Assert.assertEquals(inventoryPage.getFilterDropdown().getAttribute("value"), "az", "Name (A to Z)");
    }
}


