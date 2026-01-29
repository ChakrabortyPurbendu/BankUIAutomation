package pages;

import org.openqa.selenium.WebDriver;
import locators.HomePageLocators;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoginSuccessful() {
        return driver.findElement(HomePageLocators.managerIdText).isDisplayed();
    }
}
