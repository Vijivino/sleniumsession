package demoShopPageFactoryTEST;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	public void launchbrowser() {
	//Launch browser
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
			    HashMap<String, Object> prefs = new HashMap<String, Object>();
		        prefs.put("autofill.profile_enabled", false);
		        prefs.put("credentials_enable_service", false);
		        prefs.put("profile.password_manager_enabled", false);
		        ChromeOptions options = new ChromeOptions();
		        options.setExperimentalOption("prefs", prefs);
		    driver = new ChromeDriver(options);
			driver.get("https://demowebshop.tricentis.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	
}
