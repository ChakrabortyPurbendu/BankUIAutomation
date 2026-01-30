package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.Utility;
import locators.NewCustomerLocators;

public class NewCustomerPage {

    WebDriver driver;
    WebDriverWait wait;

    public NewCustomerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Open New Customer page
    public void openNewCustomerPage() {
        wait.until(ExpectedConditions.elementToBeClickable(
                NewCustomerLocators.newCustomerLink)).click();
    }

    // Fill New Customer form (simple sendKeys only)
    public void fillCustomerForm() throws Exception {

        // Customer Name
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                NewCustomerLocators.customerName))
                .sendKeys(Utility.properties("customer.name"));

        // Gender
        if (Utility.properties("customer.gender").equalsIgnoreCase("male")) {
            driver.findElement(NewCustomerLocators.genderMale).click();
        } else {
            driver.findElement(NewCustomerLocators.genderFemale).click();
        }

        // DOB (MM/DD/YYYY)
        driver.findElement(NewCustomerLocators.dob)
                .sendKeys(Utility.properties("customer.dob"));

        // Address
        driver.findElement(NewCustomerLocators.address)
                .sendKeys(Utility.properties("customer.address"));

        // City
        driver.findElement(NewCustomerLocators.city)
                .sendKeys(Utility.properties("customer.city"));

        // State
        driver.findElement(NewCustomerLocators.state)
                .sendKeys(Utility.properties("customer.state"));

        // PIN
        driver.findElement(NewCustomerLocators.pin)
                .sendKeys(Utility.properties("customer.pin"));

        // Mobile
        driver.findElement(NewCustomerLocators.mobile)
                .sendKeys(Utility.properties("customer.mobile"));

        // Email (unique every run)
        driver.findElement(NewCustomerLocators.email)
                .sendKeys("test" + System.currentTimeMillis() + "@gmail.com");

        // Password
        driver.findElement(NewCustomerLocators.password)
                .sendKeys(Utility.properties("customer.password"));

        // Scroll to Submit
        WebElement submitBtn = driver.findElement(NewCustomerLocators.submitBtn);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", submitBtn);

        // Click Submit using JS (avoids header overlay issue)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", submitBtn);
    }

    // Verify registration success
    public boolean isCustomerRegistered() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                NewCustomerLocators.successHeading));

        return driver.getPageSource().contains("Customer ID");
    }
}
