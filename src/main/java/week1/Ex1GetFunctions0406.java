package week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex1GetFunctions0406 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		//Get and print the page title
		System.out.println("Title of the page --- "+driver.getTitle());
		//Get and print the title length
		String title = driver.getTitle();
		System.out.println("The length of the title ---  "+title.length());
		//Get URL and validate
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.equals("https://demowebshop.tricentis.com/")) 
		{
			System.out.println("URL is verified  " +currentUrl);
		}
		else
		{
			System.out.println("URL is not verified");
		}
		//Get and print the page source 
		String pageSource = driver.getPageSource();
		System.out.println("Page Source code --- "+pageSource);
		//Get and print page source length
		System.out.println("Pagesource length --- "+pageSource.length());

	}

}
