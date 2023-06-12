package week1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles0406 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


		//first button
		driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("No.of windows after first button clicked "+windowHandles.size());
		List<String> list1=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list1.get(1));
		Thread.sleep(3000);
		driver.close();

		driver.switchTo().window(list1.get(0));

		//second button
		driver.findElement(By.xpath("//a[contains(text(),'New Seperate')]")).click();
		driver.findElement(By.xpath("//p[contains(text(),'button to open')]/following::button[text()='click']")).click();
		Set<String> Handles2 = driver.getWindowHandles();
		System.out.println("No.of windows after second button clicked "+Handles2.size());
		//		Iterator<String> iterator = windowHandles1.iterator();
		//		String window = iterator.next();
		//		String otherwindow = iterator.next();
		List<String> list2=new ArrayList<String>(Handles2);
		driver.switchTo().window(list2.get(1));
		System.out.println("other window opened "+driver.getTitle());
		driver.close();

		driver.switchTo().window(list1.get(0));

		//third button
		driver.findElement(By.xpath("//a[contains(text(),'Seperate Multiple')]")).click();
		driver.findElement(By.xpath("//*[@id=\"Multiple\"]/button")).click();
		Set<String> Handles = driver.getWindowHandles();
		List<String> list=new ArrayList<String>(Handles);
		System.out.println("No.of windows after last button clicked "+Handles.size());
		driver.switchTo().window(list.get(1));
		String title = driver.getTitle();
		System.out.println("first window opened "+title);
		//		driver.findElement(By.id("email")).sendKeys("vijayalaxmi");
		//		String name = driver.findElement(By.id("email")).getAttribute("value");
		//		System.out.println("Name entered is verified as "+name);
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(list.get(2));
		System.out.println("second window opened "+driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("vijayalaxmi");
		String name = driver.findElement(By.id("email")).getAttribute("value");
		System.out.println("Name entered is verified as "+name);
		Thread.sleep(3000);
		driver.close();
		
		driver.switchTo().window(list.get(0));


		driver.quit();		

	}

}
