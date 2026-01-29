package locators;

import org.openqa.selenium.By;

public class NewCustomerLocators {

    public static By newCustomerLink = By.linkText("New Customer");

    public static By customerName = By.name("name");
    public static By genderMale = By.xpath("//input[@value='m']");
    public static By dob = By.name("dob");
    public static By address = By.name("addr");
    public static By city = By.name("city");
    public static By state = By.name("state");
    public static By pin = By.name("pinno");
    public static By mobile = By.name("telephoneno");
    public static By email = By.name("emailid");
    public static By password = By.name("password");

    public static By submitBtn = By.name("sub");

    // Success validation
    public static By customerIdText =
            By.xpath("//*[contains(text(),'Customer ID')]");
}
