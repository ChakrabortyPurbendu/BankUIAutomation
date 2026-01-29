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

public class LoginSteps {

    LoginPage login;
    HomePage home;

    @Before
    public void setup() throws Exception {
        Browser.openBrowser();
        Browser.navigate("Guru99 Bank Home Page");
        login = new LoginPage(Browser.driver);
        home = new HomePage(Browser.driver);
    }

    @Given("user opens the Guru99 login page")
    public void user_opens_the_guru99_login_page() {
        // handled in @Before
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() throws Exception {
        login.login(
                Utility.properties("username"),
                Utility.properties("password")
        );
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        assertTrue(
                home.isLoginSuccessful(),
                "Login failed: Manager Id not displayed"
        );
    }

    @After
    public void tearDown() {
        Browser.closeBrowser();
    }
}
