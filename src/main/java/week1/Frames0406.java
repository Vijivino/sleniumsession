package week1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames0406 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        //Launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		
		//navigate to frame
		driver.switchTo().frame("singleframe");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Selenium");
		driver.switchTo().defaultContent();
			
		//Nested frames
		driver.findElement(By.xpath("//a[contains(text(),'with in')]")).click();
		WebElement parentframe = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(parentframe);
		WebElement childframe = driver.findElement(By.xpath("//h5 /following::iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(childframe);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Selenium");
		
		//driver.quit();

	}

}
