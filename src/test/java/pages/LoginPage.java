package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    @FindBy (xpath = "//*[@id=\"root\"]/div/div[1]")
    private WebElement logo;
    @FindBy (id = "login-button")
    private WebElement loginButton;

    @FindBy (id = "user-name")
    private WebElement userName;

    @FindBy (id = "password")
    private WebElement password;

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getLogo(){
        return logo;
    }

    public void fillLoginForm(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
