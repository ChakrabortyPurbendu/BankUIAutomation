package Testcase;

import browser.Browser;
import browser.Utility;
import pages.HomePage;
import pages.LoginPage;

public class Demo {
	
	public static void main(String[] args) throws Exception
	{
		Browser.openBrowser();
		Browser.navigate("Guru99 Bank Home Page");
		
		 LoginPage login = new LoginPage(Browser.driver);
	        HomePage home = new HomePage(Browser.driver);

	        login.login(
	                Utility.properties("username"),
	                Utility.properties("password")
	        );

	        if (home.isLoginSuccessful()) {
	            System.out.println("LOGIN SUCCESSFUL");
	        } else {
	            System.out.println("LOGIN FAILED");
	        }

	        Thread.sleep(3000);
	        Browser.closeBrowser();
		
	}

}
