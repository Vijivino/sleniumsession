package week1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex5WaitSynchr0406 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		//implict wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");  
		
//		//Explicit wait
//		//one way of declaration
//		WebElement username = new WebDriverWait(driver, Duration.ofSeconds(10))
//		        .until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
//		driver.findElement(By.name("username")).sendKeys("Admin");
//		//other way of declaration
//		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("password"))));
//		driver.findElement(By.name("password")).sendKeys("admin123");
		
		//fluent wait
		/*Wait<WebDriver> waitfluent = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);

				WebElement foo = wait.until(driver -> {
				  return driver.findElement(By.name("username"));
				});
		*/
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//validation
		
		boolean displayed = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).isDisplayed();
		if(displayed == true)
		{
			System.out.println("Logged in succesfully!");
		}
		
		else
		{
			System.out.println("Log in failed");	
		}
		
		
		//LogOut
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		//validation
		String text = driver.findElement(By.xpath("//h5[text()='Login']")).getText();
		if(text.equals("Login"))
		{
			System.out.println("Logout successfully done!");
		}
		
		else
		{
			System.out.println("It is not logged out");
		}

	}

}
