package week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ex2GoogleMultipleTests {

	WebDriver driver;
	
	@BeforeMethod
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void checktitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google");
		System.out.println("Title verified");
		
	}
	
	@Test
	public void checktimage() {
	
		boolean displayed = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		Assert.assertTrue(displayed);
		System.out.println("image verified");
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
}
