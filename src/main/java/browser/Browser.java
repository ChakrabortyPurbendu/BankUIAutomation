package browser;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	public static WebDriver driver; // Declared object globally
	public static WebDriverWait wait;
	public static Actions action;
	public static Select select;

	/*
	 * Open the browser based on the choice
	 */
	public static void openBrowser() throws Exception {
		try {
			String choice = Utility.properties("browser"); // Chrome
			if (choice.equalsIgnoreCase("Chrome"))
				driver = new ChromeDriver();
			else if (choice.equalsIgnoreCase("Edge"))
				driver = new EdgeDriver();
			else if (choice.equalsIgnoreCase("Firefox"))
				driver = new FirefoxDriver();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Browser - openBrowser");
		}
	}

	/*
	 * Pauses the URL of the application
	 */
	public static void navigate(String title) throws Exception {
		try {
			driver.get(Utility.properties("url")); // https://www.rediff.com
			driver.manage().window().maximize();
			action = new Actions(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleIs(title));
		} catch (Exception e) {
			System.out.println("Browser - navigate" + e);
		}
	}
	/*
	 * Closes the Browser
	 */
	public static void closeBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Browser - closeBrowser");
		}
	}
}