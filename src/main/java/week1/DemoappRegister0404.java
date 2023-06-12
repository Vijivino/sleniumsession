package week1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoappRegister0404 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		//Enter fields
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		driver.findElement(By.name("FirstName")).sendKeys("vijayalaxmi");
		driver.findElement(By.name("LastName")).sendKeys("R");
		driver.findElement(By.id("Email")).sendKeys("vijiraja@gmail.com");
		driver.findElement(By.name("Password")).sendKeys("viji123");
		Thread.sleep(2000);
		driver.findElement(By.id("ConfirmPassword")).sendKeys("viji123");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
		//Validation
		String text = driver.findElement(By.xpath("//li[contains(text(),'already')]")).getText();
		if (text.contains("already exists"))
		{
		   System.out.println("This email id exists already!!");	
		}
		else 
		{
			System.out.println("Registered successfully!");

		}
		
		//driver.close();
		
	}

}
