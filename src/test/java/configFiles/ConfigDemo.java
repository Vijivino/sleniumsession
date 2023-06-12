package configFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ConfigDemo {

	@Test
	public void login() throws IOException {
		
		WebDriver driver = null;
		
		//configure the property file
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\SeleniumSession\\src\\test\\java\\configFiles\\config.properties");
		
		//access the methods in properties class
		prop.load(fis);
		
		//get the browser name from prop file
		String browsername = prop.getProperty("browser");
		
		System.out.println();
		
		if (browsername.equalsIgnoreCase("chrome")) 
		{
			
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
            driver=new ChromeDriver();
			
		}
		
		else if(browsername.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Selenium Software\\edgedriver_win64\\msedgedriver.exe");
		    driver=new EdgeDriver();
		}
		
		else
		{
			System.out.println("Browser name not available");
		}
		
		//get url from prop file
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		//get locators from prop file
		driver.findElement(By.id("Email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.name(prop.getProperty("login_password_name"))).sendKeys(prop.getProperty("password"));
		
		
		
		
		
	}
	
	
	
	
}
