package week1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginEdge0404 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver","C:\\Selenium Software\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
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
        	System.out.println("login was successful");
        }
        
        else
        System.out.println("Unsucessfull Login");
        
       

		driver.quit();


	}

}
