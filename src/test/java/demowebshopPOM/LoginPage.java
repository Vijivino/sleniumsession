package demowebshopPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	//save the locators
	By loginlink=By.linkText("Log in");
	By emial=By.id("Email");
	By password=By.name("Password");
	By login=By.xpath("//input[@value='Log in']");
	By loginname=By.xpath("//a[contains(text(),'viji')]");

	//create constructor to invoke the driver
	public LoginPage(WebDriver driver) 
	{
	
		this.driver=driver;
     }
	
		
	//create methods to access the locators
	public void clickloginlink()
	{
		driver.findElement(loginlink).click();
	}
	
	public void enteremail(String em) 
	{
		driver.findElement(emial).sendKeys(em);
	}
	
	public void enterpassword(String pw) 
	{
		driver.findElement(password).sendKeys(pw);
	}
	
	public void clickloginbtn() 
	{
		driver.findElement(login).click();
	}
	
	public void logincheck() 
	{
		String text = driver.findElement(loginname).getText();
		 if(text.contains("viji")) 
	        {
	        	System.out.println("login was successful with id -- "+text);
	        }
	        
	        else
	        {
	        System.out.println("Unsucessfull Login");
	        }
	}
	
	public void close() 
	{
		driver.quit();
	}
	
}
