package week2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Ex3BuyLaptop0411 {

	WebDriver driver;
	@Test(dataProvider = "dp")
	public void buylaptop(String name, String password) throws InterruptedException, IOException {

		//login details
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(name);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//validation for login
		Thread.sleep(3000);
		boolean displayed = driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed();
		Assert.assertTrue(displayed);
		System.out.println("Login was done");

		//Place order for laptop
		driver.findElement(By.xpath("//input[@value='Search store']")).sendKeys("laptop" , Keys.ENTER);
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();

		//move to cart
		Actions builder=new Actions(driver);
		WebElement shopcart = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
		builder.moveToElement(shopcart).click().perform();

		//screenshot for adding it to cart 
		File source1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destiny1=new File("C:\\Selenium Software\\Ex3BuyLaptop0411\\laptopcart.png");
		FileUtils.copyFile(source1, destiny1);
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();

		//shipping address
		Select sel=new Select(driver.findElement(By.id("billing-address-select")));
		sel.selectByVisibleText("New Address");
		driver.findElement(By.id("BillingNewAddress_FirstName")).clear();
		driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Viji");
		driver.findElement(By.id("BillingNewAddress_LastName")).clear();
		driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("V");
		driver.findElement(By.id("BillingNewAddress_Email")).clear();
		driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("Viji@gmail.com");
		Select sel1=new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
		sel1.selectByValue("2");
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("toronto");
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("loyds street");
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("09876");
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("4646656536");

		//shipping method
		//driver.findElement(By.xpath("//div[@id='billing-buttons-container']/following::input[@title='Continue']")).click();
		driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();

		//choose COD
		driver.findElement(By.xpath("//label[contains(text(),'Cash On Delivery')]")).click();
		driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();

		//validation for order placed
		boolean order = driver.findElement(By.xpath("//a[contains(text(),'order details')]")).isDisplayed();
		Assert.assertTrue(order);
		String text = driver.findElement(By.xpath("//li[contains(text(),'Order number')]")).getText();
		System.out.println("Order is placed succefully   " +text);

		//screenshot for confirming order
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destiny=new File("C:\\Selenium Software\\Ex3BuyLaptop0411\\laptoporder.png");
		FileUtils.copyFile(source, destiny);


		//logout
		driver.findElement(By.xpath("//a[text()='Log out']")).click();



	}

	@BeforeMethod
	public void launch(){
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");

		//Handling the chrome popups
		//        HashMap<String, Object> prefs = new HashMap<String, Object>();
		//        prefs.put("autofill.profile_enabled", false);
		//        prefs.put("credentials_enable_service", false);
		//        prefs.put("profile.password_manager_enabled", false);
		//        ChromeOptions options = new ChromeOptions();
		//        options.setExperimentalOption("prefs", prefs);
		//        driver = new ChromeDriver(options);
		//        
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		//to disable adress save from chrome
		prefs.put("autofill.profile_enabled", false);
		options.addArguments("--disable-web-security");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-notifications");
		//to disable access denied
		options.addArguments("--disable-blink-features=AutomationControlled");
        prefs.put("useAutomationExtension", false);
		//options.setCapability("autofill.profile_enabled", false);
		//    ( options).AAddUserProfilePreferences("autofill.profile_enabled",false);
		options.setExperimentalOption("prefs", prefs);
		driver= new ChromeDriver(options);

		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();



	}

	@AfterMethod
	public void afterMethod() {

		driver.quit();
	}


	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { "vijiraja@gmail.com", "viji123" },

		};
	}
}
