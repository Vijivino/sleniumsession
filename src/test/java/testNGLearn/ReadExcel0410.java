package testNGLearn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadExcel0410 {
	
	@Test
	public void readexcel() throws IOException {
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://demowebshop.tricentis.com/");
	driver.manage().window().maximize();
	

	driver.findElement(By.linkText("Log in")).click();
	
	//Excel data 
	File credentials=new File("C:\\Selenium Software\\Book1.xlsx");
	FileInputStream credeObj=new FileInputStream(credentials);
	XSSFWorkbook exfile=new XSSFWorkbook(credeObj);
	XSSFSheet sheet1=exfile.getSheetAt(0);
	int rowNum = sheet1.getLastRowNum();
	
	for(int i=0;i<=rowNum;i++)
	{
		String email = sheet1.getRow(i).getCell(0).getStringCellValue();
		String password=sheet1.getRow(i).getCell(1).getStringCellValue();
		System.out.println(email +" "+password);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
	    driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	
	
	
	

	}
	
	
}
