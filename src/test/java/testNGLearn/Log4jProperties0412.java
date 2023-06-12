package testNGLearn;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class Log4jProperties0412 {

	WebDriver driver;


	@Test
	public void Login() throws InterruptedException {

		//configure the properties file
		Logger log = Logger.getLogger(Log4jProperties0412.class);
		PropertyConfigurator.configure("log4j.properties");

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();

		//instead of syso, use log statement
		log.info("Browser launched");


		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("vijiraja@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("viji123");

		log.info("Login details entered");

		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(3000);
		boolean displayed = driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed();
		Assert.assertTrue(displayed);

		log.warn("Login Validated");

		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		log.warn("Login chrome browser done");

	}



	@AfterMethod
	public void close() {
		driver.quit();

	}

}
