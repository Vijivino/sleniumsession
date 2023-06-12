package testNGLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods0407 {


	WebDriver driver;
	@Test(alwaysRun=true)
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
	}
	
	
	@Test(dependsOnMethods="launchbrowser",priority=1)
	public void Login() {
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("vijiraja@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("viji123");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        System.out.println("Log in done");
        
	}

	@Test(priority=2)
	public void validaton() throws InterruptedException {
        
		Thread.sleep(3000);
		boolean displayed = driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed();
		Assert.assertTrue(displayed);
		

	}
	
	
	@Test(dependsOnMethods="validaton",priority=3)
	public void Logout() {
        driver.findElement(By.xpath("//a[text()='Log out']")).click();

	}
	

	@Test(priority=4,description="Test case completed")
	public void close() {
        driver.quit();

	}
	
	
}
