package week1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginChrome0404 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("vijiraja@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("viji123");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        
       //validation
        String text = driver.findElement(By.xpath("//a[contains(text(),'viji')]")).getText();
        if(text.contains("viji")) 
        {
        	System.out.println("login was successful with id -- "+text);
        }
        
        else
        {
        System.out.println("Unsucessfull Login");
        }
        
        driver.findElement(By.xpath("//a[text()='Log out']")).click();

        driver.close();

	}

}
