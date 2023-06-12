package week1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex2Navigate0406 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		//go to registerpage
		driver.findElement(By.linkText("Register")).click();
		//navigate back to homepage
		Thread.sleep(3000);
		driver.navigate().back();
		//navigate to registerpage
		Thread.sleep(3000);
		driver.navigate().forward();
		//go to homepage
		Thread.sleep(3000);
		driver.navigate().to("https://demowebshop.tricentis.com/");
		//refresh 
		driver.navigate().refresh();
		
		driver.quit();

	}

}
