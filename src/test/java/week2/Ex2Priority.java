package week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex2Priority {
	
	WebDriver driver;
	@Test
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
	}
	
	
	@Test(priority=1)
	public void Login() {
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("vijiraja@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("viji123");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        
	}

	@Test(priority=2)
	public void validaton() {
        String text = driver.findElement(By.xpath("//a[contains(text(),'viji')]")).getText();
        Assert.assertTrue(text.contains("viji"));

	}
	
	
	@Test(priority=3)
	public void Logout() {
        driver.findElement(By.xpath("//a[text()='Log out']")).click();

	}
	

	@Test(priority=4)
	public void close() {
        driver.quit();

	}
	
	


}
