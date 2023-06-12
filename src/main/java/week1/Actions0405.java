package week1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions0405 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("selenium" );
		
		//using action class press enter
		Actions builder=new Actions(driver);
		builder.sendKeys(Keys.ENTER).perform();
		
		System.out.println("Selenium loaded successfully");
		
		driver.quit();
		
	}

}
