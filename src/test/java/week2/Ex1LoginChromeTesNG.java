package week2;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Ex1LoginChromeTesNG {

    WebDriver driver;
	
    @BeforeMethod(alwaysRun=true)
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void Login() throws InterruptedException {
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("vijiraja@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("viji123");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        Thread.sleep(3000);
		boolean displayed = driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed();
		Assert.assertTrue(displayed);
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		System.out.println("Login chrome browser done");
        
	}

	

	@AfterMethod
	public void close() {
        driver.quit();

	}
	
	
}
