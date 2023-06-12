package toolsQA;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Registration {

	WebDriver driver;

	@Test(description="In the correct page")
	public void launch() {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("autofill.profile_enabled", false);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


	}

	@Test(priority=1)
	public void enterName() throws IOException {

		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\SeleniumSession\\src\\test\\java\\toolsQA\\config.properties");
		prop.load(fis);


		driver.findElement(By.id("firstName")).sendKeys(prop.getProperty("fname"));
		driver.findElement(By.id("lastName")).sendKeys(prop.getProperty("lname"));

	}

	@Test(priority=2)
	public void enteremail() {

		driver.findElement(By.id("userEmail")).sendKeys("viji@gmail.com");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "DEMOQA");
	}

	@Test(priority=3)
	public void enterAllFields() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//scroll down the window
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		driver.findElement(By.xpath("//label[text()='Female']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");
		
        driver.findElement(By.xpath("//div[@class='react-datepicker__input-container']/input")).click();
		Select sel=new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
		sel.selectByVisibleText("March");
		Select sel1=new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		sel1.selectByValue("1994");
		driver.findElement(By.xpath("//div[text()='19']")).click();
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("window.scrollBy(0,250)");
	    //driver.findElement(By.xpath("//label[text()='Subjects']//following::div[@id='subjectsContainer']")).sendKeys("english",Keys.ENTER);
		driver.findElement(By.xpath("//label[text()='Reading']")).click();
		
	}

	@AfterMethod
	public void close() {

		//driver.quit();
	}



}
