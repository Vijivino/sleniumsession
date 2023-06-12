package sampleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Calendar {

	@Test
	public void HandleDate() {

		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//img[@class='imgdp']")).click();

				WebElement element = driver.findElement(By.id("datepicker1"));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].value='05/16/2013'", element);

/*		while(true)	
		{
			String titleyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(titleyear.contains("2021")) {
				break;
			}
			else {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
		}

		driver.findElement(By.xpath("//table/tbody/tr/td/a[text()='16']")).click();
	*/
	}

}
