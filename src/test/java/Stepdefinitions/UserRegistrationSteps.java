package Stepdefinitions;

import static org.testng.Assert.assertTrue;

import browser.Browser;
import browser.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.NewCustomerPage;

public class UserRegistrationSteps {

    LoginPage login;
    HomePage home;
    NewCustomerPage customer;

    @Before
    public void setup() throws Exception {

        Browser.openBrowser();
        Browser.navigate("Guru99 Bank Home Page");

        login = new LoginPage(Browser.driver);
        home = new HomePage(Browser.driver);
        customer = new NewCustomerPage(Browser.driver);

        // Login once before registration
        login.login(
                Utility.properties("username"),
                Utility.properties("password")
        );
    }

    @Given("user is logged in to Guru99 bank")
    public void user_is_logged_in_to_guru99_bank() {

        assertTrue(
                home.isLoginSuccessful(),
                "Login failed, cannot proceed with registration"
        );

        // Navigate to New Customer page
        customer.openNewCustomerPage();
    }

    @When("user enters valid customer details")
    public void user_enters_valid_customer_details() {

        // Fill complete form from Page class
        customer.fillCustomerForm();
    }

    @Then("customer should be registered successfully")
    public void customer_should_be_registered_successfully() {

        assertTrue(
                customer.isCustomerRegistered(),
                "Customer registration failed"
        );
    }

    @After
    public void tearDown() {
        Browser.closeBrowser();
    }
}
