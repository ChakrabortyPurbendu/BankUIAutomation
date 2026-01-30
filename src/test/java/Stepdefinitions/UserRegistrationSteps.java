package Stepdefinitions;

import static org.testng.Assert.assertTrue;

import browser.Browser;
import browser.Utility;
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

        login.login(
                Utility.properties("username"),
                Utility.properties("password")
        );
    }

    @Given("user is logged in and on new customer page")
    public void user_is_logged_in_and_on_new_customer_page() {
        assertTrue(home.isLoginSuccessful());
        customer.openNewCustomerPage();
    }

    @When("user enters customer details")
    public void user_enters_customer_details() throws Exception {
        customer.fillCustomerForm();
    }

    @Then("customer should be registered successfully")
    public void customer_should_be_registered_successfully() {
        assertTrue(customer.isCustomerRegistered());
    }

    @After
    public void tearDown() {
        Browser.closeBrowser();
    }
}
