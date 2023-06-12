package week1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex3Alert0405 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
	

		//alert
		driver.findElement(By.xpath("//button[contains(text(),'click the button to display an')]")).click();
        Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		//Validation
		System.out.println("Alert text captured is --- " +text);
		alert.accept();
		
		driver.findElement(By.xpath("//a[contains(text(),'OK & Cancel')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'display a ')]")).click();
		alert.dismiss();
		//Validation
		String canceltext = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println("Alert dismiss confirmed with following text --- " +canceltext);
		
		driver.findElement(By.xpath("//a[contains(text(),'Textbox')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'prompt box')]")).click();
		alert.sendKeys("Vijayalaxmi");
		alert.accept();
		//Validation
		String prompttext = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
		System.out.println("Alert with textbox validated with this text --- " +prompttext);

		driver.quit();

	}

}
