package week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ex1LoginEdgeTestNG {

	WebDriver driver;

	@BeforeMethod
	public void launchbrowser() {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","C:\\Selenium Software\\edgedriver_win64\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
	}	
	
	@Test
	public void login() {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("vijiraja@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("viji123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();

		//validation
		String text = driver.findElement(By.xpath("//a[contains(text(),'viji')]")).getText();
		Assert.assertTrue(text.contains("viji"));
		System.out.println("Login Edge browser done");

	}

	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}

}


