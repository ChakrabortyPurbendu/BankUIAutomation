package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.NewCustomerLocators;

public class NewCustomerPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public NewCustomerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
    }

    /* =========================
       STEP 1: OPEN PAGE
       ========================= */
    public void openNewCustomerPage() {

        wait.until(ExpectedConditions.elementToBeClickable(
                NewCustomerLocators.newCustomerLink)).click();

        // Ensure page loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                NewCustomerLocators.customerName));
    }

    /* =========================
       STEP 2: SCROLL DOWN
       ========================= */
    private void scrollToForm() {

        WebElement nameField =
                driver.findElement(NewCustomerLocators.customerName);

        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
                nameField);

        pause();
    }

    /* =========================
       STEP 3: FILL FORM
       ========================= */
    public void fillCustomerForm() {

        scrollToForm();

        type(NewCustomerLocators.customerName, "Test User");
        click(NewCustomerLocators.genderMale);

        // DOB handled via JS (Guru99 requirement)
        WebElement dob = driver.findElement(NewCustomerLocators.dob);
        js.executeScript("arguments[0].value='1995-01-01';", dob);
        pause();

        type(NewCustomerLocators.address, "Kolkata");
        type(NewCustomerLocators.city, "Kolkata");
        type(NewCustomerLocators.state, "WB");
        type(NewCustomerLocators.pin, "700001");
        type(NewCustomerLocators.mobile, "9876543210");

        type(NewCustomerLocators.email,
                "test" + System.currentTimeMillis() + "@mail.com");

        type(NewCustomerLocators.password, "password123");

        click(NewCustomerLocators.submitBtn);
    }

    /* =========================
       STEP 4: VERIFY & SCROLL UP
       ========================= */
    public boolean isCustomerRegistered() {

        WebElement customerId =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        NewCustomerLocators.customerIdText));

        // Smooth scroll UP to result
        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
                customerId);

        pause();

        return customerId.isDisplayed();
    }

    /* =========================
       HELPERS
       ========================= */
    private void type(By locator, String value) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
        pause();
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        pause();
    }

    private void pause() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}