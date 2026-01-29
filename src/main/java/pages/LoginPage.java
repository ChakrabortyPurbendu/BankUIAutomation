package pages;

import org.openqa.selenium.WebDriver;
import locators.LoginPageLocators;

public class LoginPage {

    WebDriver driver;

    // constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserId(String uid) {
        driver.findElement(LoginPageLocators.userId).sendKeys(uid);
    }

    public void enterPassword(String pwd) {
        driver.findElement(LoginPageLocators.password).sendKeys(pwd);
    }

    public void clickLogin() {
        driver.findElement(LoginPageLocators.loginBtn).click();
    }

    public void login(String uid, String pwd) {
        enterUserId(uid);
        enterPassword(pwd);
        clickLogin();
    }
}
