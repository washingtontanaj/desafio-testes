package Core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
