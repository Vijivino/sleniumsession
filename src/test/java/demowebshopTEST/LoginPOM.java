package demowebshopTEST;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import demowebshopPOM.LoginPage;

public class LoginPOM {

	@Test
	public void login() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		//create obj to call the methods
		LoginPage login=new LoginPage(driver);
		
		//call the methods needed
		login.clickloginlink();
		login.enteremail("vijiraja@gmail.com");
		login.enterpassword("viji123");
		login.clickloginbtn();
		login.logincheck();
		login.close();
		 
		
	}
	
}
