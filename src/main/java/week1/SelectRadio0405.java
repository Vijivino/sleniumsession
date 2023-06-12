package week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectRadio0405 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();

		//Radio button
		driver.findElement(By.xpath("//input[@value='FeMale']")).click();

		//Select dropdown
		WebElement select = driver.findElement(By.id("Skills"));
		Select sel=new Select(select);
		//sel.selectByIndex(1);
		//sel.selectByValue("Android");
		sel.selectByVisibleText("Certifications");
		
		//to know the size of dropdown
		List<WebElement> options = sel.getOptions();
		System.out.println("Drop down options count in skills" +" "+options.size());
		//to print the entire options in dropdown
		System.out.println("The entire list of options in dropdown ");
		
		//initlise a list to store text of drpdown options so that we can compare
		List<String> textlist=new ArrayList<String>(); 
		for(int i=0;i<options.size();i++)
		{
			textlist.add(options.get(i).getText());
			}
		//System.out.println("original list "+textlist);
		
		//save the list to a temp list so that can compare after sorting
		List<String> actuallist=new ArrayList<String>(); 
		for(int i=0;i<options.size();i++)
		{
			actuallist.add(options.get(i).getText());
			}
		System.out.println("original list "+actuallist);
		
		//create other list to store the sorted list 
//		List<String> originalList = textlist;
//		System.out.println("original list "+originalList);
		Collections.sort(textlist);
		System.out.println("sorted list "+textlist);

		//check dropdown in ascending order one way
		 if(actuallist.equals(textlist)) {
//		if(actuallist==textlist) {
			System.out.println("The list is in ascending order");
		}else {
			System.out.println("The list is not sorted");
		}
	
		//check for sorting one by one 
		boolean flag = true;
        for (int i = 0; i < textlist.size(); i++) {
		    if (textlist.get(i).equals(actuallist.get(i)))
		    {
		    	//flag=true;
		    	break;
		    }
		    else {
		    	flag=false; 	
		    	//System.out.println("the list is not sorted");
		    }    
		}
	
		System.out.println(flag);
		
		if(flag) {
		System.out.println("Drop-down values are in ascending order");
		}
		else {
			System.out.println("the list is not sorted");
		}
	
		//Select year,month,day
		WebElement year = driver.findElement(By.xpath("//select[@placeholder='Year']"));
		Select yea=new Select(year);
		yea.selectByValue("1930");
		
		WebElement month = driver.findElement(By.xpath("//select[@placeholder='Month']"));
		Select mon=new Select(month);
		mon.selectByVisibleText("May");
		
		WebElement day = driver.findElement(By.xpath("//select[@placeholder='Day']"));
		Select dayobj=new Select(day);
		dayobj.selectByIndex(2);

		//driver.quit();

}

}
